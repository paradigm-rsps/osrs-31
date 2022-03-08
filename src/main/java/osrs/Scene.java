package osrs;

import osrs.cache.Definitions;

public class Scene {
    public static boolean Scene_isLowDetail = true;
    static int tileUpdateCount = 0;
    static int Scene_plane = 0;
    static int Scene_drawnCount;
    static int Scene_cameraXTileMin;
    static int Scene_cameraXTileMax;
    static int Scene_cameraYTileMin;
    static int Scene_cameraYTileMax;
    static int Scene_cameraXTile;
    static int Scene_cameraYTile;
    static int Scene_cameraX;
    static int Scene_cameraY;
    static int Scene_cameraZ;
    static int Scene_cameraPitchSine;
    static int Scene_cameraPitchCosine;
    static int Scene_cameraYawSine;
    static int Scene_cameraYawCosine;
    static GameObject[] gameObjects = new GameObject[100];
    static boolean checkClick = false;
    static int Scene_selectedPlane = 0;
    static int Scene_selectedScreenX = 0;
    static int Scene_selectedScreenY = 0;
    public static int Scene_selectedX = -1;
    public static int Scene_selectedY = -1;
    static int Scene_planesCount = 4;
    static int[] Scene_planeOccluderCounts;
    static Occluder[][] Scene_planeOccluders;
    static int Scene_currentOccludersCount;
    static Occluder[] Scene_currentOccluders;
    static NodeDeque Scene_tilesDeque;
    static final int[] field1595;
    static final int[] field1596;
    static final int[] field1583;
    static final int[] field1598;
    static final int[] field1599;
    static final int[] field1600;
    static final int[] field1601;
    static boolean[][][][] field1569;
    static boolean[][] visibleTiles;
    static int Scene_viewportXCenter;
    static int Scene_viewportYCenter;
    static int Scene_viewportXMin;
    static int Scene_viewportYMin;
    static int Scene_viewportXMax;
    static int Scene_viewportYMax;
    int planes;
    int xSize;
    int ySize;
    int[][][] tileHeights;
    Tile[][][] tiles;
    int minPlane = 0;
    int tempGameObjectsCount = 0;
    GameObject[] tempGameObjects = new GameObject[5000];
    int[][][] field1558;
    int[][] tileShape2D = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
    int[][] tileRotation2D = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};

    static {
        Scene_planeOccluderCounts = new int[Scene_planesCount];
        Scene_planeOccluders = new Occluder[Scene_planesCount][500];
        Scene_currentOccludersCount = 0;
        Scene_currentOccluders = new Occluder[500];
        Scene_tilesDeque = new NodeDeque();
        field1595 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
        field1596 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
        field1583 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
        field1598 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
        field1599 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
        field1600 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
        field1601 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
        field1569 = new boolean[8][32][51][51];
    }

    public Scene(int var1, int var2, int var3, int[][][] var4) {
        this.planes = var1;
        this.xSize = var2;
        this.ySize = var3;
        this.tiles = new Tile[var1][var2][var3];
        this.field1558 = new int[var1][var2 + 1][var3 + 1];
        this.tileHeights = var4;
        this.method2138();
    }

    static void loadObject(int var0, int plane, int x, int y, int id, int orientation, int type, Scene scene, CollisionMap collisionMap) {
        ObjectDefinition definition = Definitions.getObject(id);
        int var10;
        int var11;
        if (orientation != 1 && orientation != 3) {
            var10 = definition.sizeX;
            var11 = definition.sizeY;
        } else {
            var10 = definition.sizeY;
            var11 = definition.sizeX;
        }

        int var12;
        int var13;
        if (var10 + x <= 104) {
            var12 = (var10 >> 1) + x;
            var13 = x + (var10 + 1 >> 1);
        } else {
            var12 = x;
            var13 = x + 1;
        }

        int var14;
        int var15;
        if (y + var11 <= 104) {
            var14 = y + (var11 >> 1);
            var15 = y + (var11 + 1 >> 1);
        } else {
            var14 = y;
            var15 = y + 1;
        }

        int[][] var16 = Tiles.tileHeights[plane];
        int calculatedType = var16[var12][var15] + var16[var13][var14] + var16[var12][var14] + var16[var13][var15] >> 2;
        int var18 = (x << 7) + (var10 << 6);
        int var19 = (y << 7) + (var11 << 6);
        int var20 = (y << 7) + x + (id << 14) + 1073741824;
        if (definition.int1 == 0) {
            var20 -= Integer.MIN_VALUE;
        }

        int var21 = (orientation << 6) + type;
        if (definition.int3 == 1) {
            var21 += 256;
        }


        Renderable floorDecorationModel;
        Renderable boundaryObjectModel;
        Renderable gameObjectModel;
        Renderable wallDecorationModel;
        if (type == 22) {
            if (definition.animationId == -1 && definition.transforms == null) {
                floorDecorationModel = definition.getModel(22, orientation, var16, var18, calculatedType, var19);
            } else {
                floorDecorationModel = new DynamicObject(id, 22, orientation, plane, x, y, definition.animationId, true, null);
            }

            scene.setFloorDecoration(var0, x, y, calculatedType, floorDecorationModel, var20, var21);
            if (definition.interactType == 1) {
                collisionMap.method3430(x, y);
            }

        } else if (type != 10 && type != 11) {

            if (type >= 12) {
                if (definition.animationId == -1 && definition.transforms == null) {
                    gameObjectModel = definition.getModel(type, orientation, var16, var18, calculatedType, var19);
                } else {
                    gameObjectModel = new DynamicObject(id, type, orientation, plane, x, y, definition.animationId, true, null);
                }

                scene.addGameObject(var0, x, y, calculatedType, 1, 1, gameObjectModel, 0, var20, var21);
                if (definition.interactType != 0) {
                    collisionMap.method3428(x, y, var10, var11, definition.boolean1);
                }
            } else if (type == 0) {

                if (definition.animationId == -1 && definition.transforms == null) {
                    boundaryObjectModel = definition.getModel(0, orientation, var16, var18, calculatedType, var19);
                } else {
                    boundaryObjectModel = new DynamicObject(id, 0, orientation, plane, x, y, definition.animationId, true, null);
                }

                scene.setBoundaryObject(var0, x, y, calculatedType, boundaryObjectModel, null, Tiles.field124[orientation], 0, var20, var21);
                if (definition.interactType != 0) {
                    collisionMap.method3427(x, y, type, orientation, definition.boolean1);
                }

            } else if (type == 1) {
                if (definition.animationId == -1 && definition.transforms == null) {
                    boundaryObjectModel = definition.getModel(1, orientation, var16, var18, calculatedType, var19);
                } else {
                    boundaryObjectModel = new DynamicObject(id, 1, orientation, plane, x, y, definition.animationId, true, null);
                }

                scene.setBoundaryObject(var0, x, y, calculatedType, boundaryObjectModel, null, Tiles.field125[orientation], 0, var20, var21);
                if (definition.interactType != 0) {
                    collisionMap.method3427(x, y, type, orientation, definition.boolean1);
                }

            } else {
                int var22;
                Renderable renderable;
                if (type == 2) {
                    var22 = orientation + 1 & 3;
                    Renderable renderable1;
                    if (definition.animationId == -1 && definition.transforms == null) {
                        renderable1 = definition.getModel(2, orientation + 4, var16, var18, calculatedType, var19);
                        renderable = definition.getModel(2, var22, var16, var18, calculatedType, var19);
                    } else {
                        renderable1 = new DynamicObject(id, 2, orientation + 4, plane, x, y, definition.animationId, true, null);
                        renderable = new DynamicObject(id, 2, var22, plane, x, y, definition.animationId, true, null);
                    }

                    scene.setBoundaryObject(var0, x, y, calculatedType, renderable1, renderable, Tiles.field124[orientation], Tiles.field124[var22], var20, var21);
                    if (definition.interactType != 0) {
                        collisionMap.method3427(x, y, type, orientation, definition.boolean1);
                    }

                } else if (type == 3) {
                    if (definition.animationId == -1 && definition.transforms == null) {
                        boundaryObjectModel = definition.getModel(3, orientation, var16, var18, calculatedType, var19);
                    } else {
                        boundaryObjectModel = new DynamicObject(id, 3, orientation, plane, x, y, definition.animationId, true, null);
                    }

                    scene.setBoundaryObject(var0, x, y, calculatedType, boundaryObjectModel, null, Tiles.field125[orientation], 0, var20, var21);
                    if (definition.interactType != 0) {
                        collisionMap.method3427(x, y, type, orientation, definition.boolean1);
                    }

                } else if (type == 9) {
                    if (definition.animationId == -1 && definition.transforms == null) {
                        gameObjectModel = definition.getModel(type, orientation, var16, var18, calculatedType, var19);
                    } else {
                        gameObjectModel = new DynamicObject(id, type, orientation, plane, x, y, definition.animationId, true, null);
                    }

                    scene.addGameObject(var0, x, y, calculatedType, 1, 1, gameObjectModel, 0, var20, var21);
                    if (definition.interactType != 0) {
                        collisionMap.method3428(x, y, var10, var11, definition.boolean1);
                    }

                } else if (type == 4) {
                    if (definition.animationId == -1 && definition.transforms == null) {
                        wallDecorationModel = definition.getModel(4, orientation, var16, var18, calculatedType, var19);
                    } else {
                        wallDecorationModel = new DynamicObject(id, 4, orientation, plane, x, y, definition.animationId, true, null);
                    }

                    scene.setWallDecoration(var0, x, y, calculatedType, wallDecorationModel, null, Tiles.field124[orientation], 0, 0, 0, var20, var21);
                } else {
                    int var23;
                    if (type == 5) {
                        var22 = 16;
                        int packedId = scene.method2057(var0, x, y);
                        if (packedId != 0) {
                            var22 = Definitions.getObject(packedId >> 14 & 32767).int2;
                        }

                        if (definition.animationId == -1 && definition.transforms == null) {
                            wallDecorationModel = definition.getModel(4, orientation, var16, var18, calculatedType, var19);
                        } else {
                            wallDecorationModel = new DynamicObject(id, 4, orientation, plane, x, y, definition.animationId, true, null);
                        }

                        scene.setWallDecoration(var0, x, y, calculatedType, wallDecorationModel, null, Tiles.field124[orientation], 0, var22 * Tiles.field115[orientation], var22 * Tiles.field127[orientation], var20, var21);
                    } else if (type == 6) {
                        var22 = 8;
                        int packedId = scene.method2057(var0, x, y);
                        if (packedId != 0) {
                            var22 = Definitions.getObject(packedId >> 14 & 32767).int2 / 2;
                        }

                        if (definition.animationId == -1 && definition.transforms == null) {
                            wallDecorationModel = definition.getModel(4, orientation + 4, var16, var18, calculatedType, var19);
                        } else {
                            wallDecorationModel = new DynamicObject(id, 4, orientation + 4, plane, x, y, definition.animationId, true, null);
                        }

                        scene.setWallDecoration(var0, x, y, calculatedType, wallDecorationModel, null, 256, orientation, var22 * Tiles.field128[orientation], var22 * Tiles.field134[orientation], var20, var21);
                    } else if (type == 7) {
                        var23 = orientation + 2 & 3;
                        if (definition.animationId == -1 && definition.transforms == null) {
                            wallDecorationModel = definition.getModel(4, var23 + 4, var16, var18, calculatedType, var19);
                        } else {
                            wallDecorationModel = new DynamicObject(id, 4, var23 + 4, plane, x, y, definition.animationId, true, null);
                        }

                        scene.setWallDecoration(var0, x, y, calculatedType, wallDecorationModel, null, 256, var23, 0, 0, var20, var21);
                    } else if (type == 8) {
                        var22 = 8;
                        int packedId = scene.method2057(var0, x, y);
                        if (packedId != 0) {
                            var22 = Definitions.getObject(packedId >> 14 & 32767).int2 / 2;
                        }

                        int var26 = orientation + 2 & 3;
                        Renderable wallDecorationModel1;
                        if (definition.animationId == -1 && definition.transforms == null) {
                            wallDecorationModel = definition.getModel(4, orientation + 4, var16, var18, calculatedType, var19);
                            wallDecorationModel1 = definition.getModel(4, var26 + 4, var16, var18, calculatedType, var19);
                        } else {
                            wallDecorationModel = new DynamicObject(id, 4, orientation + 4, plane, x, y, definition.animationId, true, null);
                            wallDecorationModel1 = new DynamicObject(id, 4, var26 + 4, plane, x, y, definition.animationId, true, null);
                        }

                        scene.setWallDecoration(var0, x, y, calculatedType, wallDecorationModel, wallDecorationModel1, 256, orientation, var22 * Tiles.field128[orientation], var22 * Tiles.field134[orientation], var20, var21);
                    }
                }
            }
        } else {
            if (definition.animationId == -1 && definition.transforms == null) {
                gameObjectModel = definition.getModel(10, orientation, var16, var18, calculatedType, var19);
            } else {
                gameObjectModel = new DynamicObject(id, 10, orientation, plane, x, y, definition.animationId, true, null);
            }

            if (gameObjectModel != null) {
                scene.addGameObject(var0, x, y, calculatedType, var10, var11, gameObjectModel, type == 11 ? 256 : 0, var20, var21);
            }

            if (definition.interactType != 0) {
                collisionMap.method3428(x, y, var10, var11, definition.boolean1);
            }

        }
    }

    public void method2138() {
        int var1;
        int var2;
        for (var1 = 0; var1 < this.planes; ++var1) {
            for (var2 = 0; var2 < this.xSize; ++var2) {
                for (int var3 = 0; var3 < this.ySize; ++var3) {
                    this.tiles[var1][var2][var3] = null;
                }
            }
        }

        for (var1 = 0; var1 < Scene_planesCount; ++var1) {
            for (var2 = 0; var2 < Scene_planeOccluderCounts[var1]; ++var2) {
                Scene_planeOccluders[var1][var2] = null;
            }

            Scene_planeOccluderCounts[var1] = 0;
        }

        for (var1 = 0; var1 < this.tempGameObjectsCount; ++var1) {
            this.tempGameObjects[var1] = null;
        }

        this.tempGameObjectsCount = 0;

        for (var1 = 0; var1 < gameObjects.length; ++var1) {
            gameObjects[var1] = null;
        }

    }

    public void method2126(int var1) {
        this.minPlane = var1;

        for (int var2 = 0; var2 < this.xSize; ++var2) {
            for (int var3 = 0; var3 < this.ySize; ++var3) {
                if (this.tiles[var1][var2][var3] == null) {
                    this.tiles[var1][var2][var3] = new Tile(var1, var2, var3);
                }
            }
        }

    }

    public void method2044(int var1, int var2) {
        Tile var3 = this.tiles[0][var1][var2];

        for (int var4 = 0; var4 < 3; ++var4) {
            Tile var5 = this.tiles[var4][var1][var2] = this.tiles[var4 + 1][var1][var2];
            if (var5 != null) {
                --var5.plane;

                for (int var6 = 0; var6 < var5.gameObjectsCount; ++var6) {
                    GameObject var7 = var5.gameObjects[var6];
                    if ((var7.packedId >> 29 & 3) == 2 && var7.startX == var1 && var2 == var7.startY) {
                        --var7.plane;
                    }
                }
            }
        }

        if (this.tiles[0][var1][var2] == null) {
            this.tiles[0][var1][var2] = new Tile(0, var1, var2);
        }

        this.tiles[0][var1][var2].linkedBelowTile = var3;
        this.tiles[3][var1][var2] = null;
    }

    public void method2046(int var1, int var2, int var3, int var4) {
        Tile var5 = this.tiles[var1][var2][var3];
        if (var5 != null) {
            this.tiles[var1][var2][var3].minPlane = var4;
        }
    }

    public void method2047(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18, int var19, int var20) {
        SceneTilePaint var21;
        int var22;
        if (var4 == 0) {
            var21 = new SceneTilePaint(var11, var12, var13, var14, -1, var19, false);

            for (var22 = var1; var22 >= 0; --var22) {
                if (this.tiles[var22][var2][var3] == null) {
                    this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].paint = var21;
        } else if (var4 != 1) {
            SceneTileModel var23 = new SceneTileModel(var4, var5, var6, var2, var3, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20);

            for (var22 = var1; var22 >= 0; --var22) {
                if (this.tiles[var22][var2][var3] == null) {
                    this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].model = var23;
        } else {
            var21 = new SceneTilePaint(var15, var16, var17, var18, var6, var20, var8 == var7 && var7 == var9 && var10 == var7);

            for (var22 = var1; var22 >= 0; --var22) {
                if (this.tiles[var22][var2][var3] == null) {
                    this.tiles[var22][var2][var3] = new Tile(var22, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].paint = var21;
        }
    }

    public void setFloorDecoration(int plane, int sceneX, int sceneY, int tileHeight, Renderable renderable, int var6, int var7) {
        if (renderable != null) {
            FloorDecoration floorDecoration = new FloorDecoration();
            floorDecoration.renderable = renderable;
            floorDecoration.x = sceneX * 128 + 64;
            floorDecoration.y = sceneY * 128 + 64;
            floorDecoration.tileHeight = tileHeight;
            floorDecoration.packedId = var6;
            floorDecoration.flags = var7;
            if (this.tiles[plane][sceneX][sceneY] == null) {
                this.tiles[plane][sceneX][sceneY] = new Tile(plane, sceneX, sceneY);
            }

            this.tiles[plane][sceneX][sceneY].floorDecoration = floorDecoration;
        }
    }

    public void addLoot(int plane, int sceneX, int sceneY, int tileHeight, Renderable drawnLayer1, int var6, Renderable drawnLayer2, Renderable drawnLayer3) {
        Loot loot = new Loot();
        loot.drawnLayer1 = drawnLayer1;
        loot.drawnLayer2 = drawnLayer2;
        loot.drawnLayer3 = drawnLayer3;
        loot.x = sceneX * 128 + 64;
        loot.y = sceneY * 128 + 64;
        loot.tileHeight = tileHeight;
        loot.field1664 = var6;
        int modelHeight = 0;
        Tile tile = this.tiles[plane][sceneX][sceneY];
        if (tile != null) {
            for (int var12 = 0; var12 < tile.gameObjectsCount; ++var12) {
                if ((tile.gameObjects[var12].flags & 256) == 256 && tile.gameObjects[var12].renderable instanceof Model model) {
                    model.method2427();
                    if (model.height > modelHeight) {
                        modelHeight = model.height;
                    }
                }
            }
        }

        loot.height = modelHeight;
        if (this.tiles[plane][sceneX][sceneY] == null) {
            this.tiles[plane][sceneX][sceneY] = new Tile(plane, sceneX, sceneY);
        }

        this.tiles[plane][sceneX][sceneY].loot = loot;
    }

    public void setBoundaryObject(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10) {
        if (var5 != null || var6 != null) {
            BoundaryObject var11 = new BoundaryObject();
            var11.packedId = var9;
            var11.flags = var10;
            var11.x = var2 * 128 + 64;
            var11.y = var3 * 128 + 64;
            var11.tileHeight = var4;
            var11.renderable1 = var5;
            var11.renderable2 = var6;
            var11.orientationA = var7;
            var11.orientationB = var8;

            for (int var12 = var1; var12 >= 0; --var12) {
                if (this.tiles[var12][var2][var3] == null) {
                    this.tiles[var12][var2][var3] = new Tile(var12, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].boundaryObject = var11;
        }
    }

    public void setWallDecoration(int var1, int var2, int var3, int var4, Renderable var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
        if (var5 != null) {
            WallDecoration var13 = new WallDecoration();
            var13.packedId = var11;
            var13.flags = var12;
            var13.x = var2 * 128 + 64;
            var13.y = var3 * 128 + 64;
            var13.tileHeight = var4;
            var13.renderable1 = var5;
            var13.renderable2 = var6;
            var13.orientation = var7;
            var13.orientation2 = var8;
            var13.xOffset = var9;
            var13.yOffset = var10;

            for (int var14 = var1; var14 >= 0; --var14) {
                if (this.tiles[var14][var2][var3] == null) {
                    this.tiles[var14][var2][var3] = new Tile(var14, var2, var3);
                }
            }

            this.tiles[var1][var2][var3].wallDecoration = var13;
        }
    }

    public boolean addGameObject(int var1, int var2, int var3, int var4, int var5, int var6, Renderable var7, int var8, int var9, int var10) {
        if (var7 == null) {
            return true;
        } else {
            int var11 = var5 * 64 + var2 * 128;
            int var12 = var6 * 64 + var3 * 128;
            return this.method2054(var1, var2, var3, var5, var6, var11, var12, var4, var7, var8, false, var9, var10);
        }
    }

    public boolean method2094(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, boolean var9) {
        if (var6 == null) {
            return true;
        } else {
            int var10 = var2 - var5;
            int var11 = var3 - var5;
            int var12 = var5 + var2;
            int var13 = var3 + var5;
            if (var9) {
                if (var7 > 640 && var7 < 1408) {
                    var13 += 128;
                }

                if (var7 > 1152 && var7 < 1920) {
                    var12 += 128;
                }

                if (var7 > 1664 || var7 < 384) {
                    var11 -= 128;
                }

                if (var7 > 128 && var7 < 896) {
                    var10 -= 128;
                }
            }

            var10 /= 128;
            var11 /= 128;
            var12 /= 128;
            var13 /= 128;
            return this.method2054(var1, var10, var11, var12 - var10 + 1, var13 - var11 + 1, var2, var3, var4, var6, var7, true, var8, 0);
        }
    }

    public boolean method2053(int var1, int var2, int var3, int var4, int var5, Renderable var6, int var7, int var8, int var9, int var10, int var11, int var12) {
        return var6 == null || this.method2054(var1, var9, var10, var11 - var9 + 1, var12 - var10 + 1, var2, var3, var4, var6, var7, true, var8, 0);
    }

    boolean method2054(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, Renderable var9, int var10, boolean var11, int var12, int var13) {
        int var15;
        for (int var14 = var2; var14 < var2 + var4; ++var14) {
            for (var15 = var3; var15 < var3 + var5; ++var15) {
                if (var14 < 0 || var15 < 0 || var14 >= this.xSize || var15 >= this.ySize) {
                    return false;
                }

                Tile tile = this.tiles[var1][var14][var15];
                if (tile != null && tile.gameObjectsCount >= 5) {
                    return false;
                }
            }
        }

        GameObject gameObject = new GameObject();
        gameObject.packedId = var12;
        gameObject.flags = var13;
        gameObject.plane = var1;
        gameObject.centerX = var6;
        gameObject.centerY = var7;
        gameObject.height = var8;
        gameObject.renderable = var9;
        gameObject.field1645 = var10;
        gameObject.startX = var2;
        gameObject.startY = var3;
        gameObject.endX = var2 + var4 - 1;
        gameObject.endY = var3 + var5 - 1;

        for (var15 = var2; var15 < var2 + var4; ++var15) {
            for (int var16 = var3; var16 < var3 + var5; ++var16) {
                int var17 = 0;
                if (var15 > var2) {
                    ++var17;
                }

                if (var15 < var2 + var4 - 1) {
                    var17 += 4;
                }

                if (var16 > var3) {
                    var17 += 8;
                }

                if (var16 < var3 + var5 - 1) {
                    var17 += 2;
                }

                for (int var18 = var1; var18 >= 0; --var18) {
                    if (this.tiles[var18][var15][var16] == null) {
                        this.tiles[var18][var15][var16] = new Tile(var18, var15, var16);
                    }
                }

                Tile var21 = this.tiles[var1][var15][var16];
                var21.gameObjects[var21.gameObjectsCount] = gameObject;
                var21.gameObjectEdgeMasks[var21.gameObjectsCount] = var17;
                var21.gameObjectsEdgeMask |= var17;
                ++var21.gameObjectsCount;
            }
        }

        if (var11) {
            this.tempGameObjects[this.tempGameObjectsCount++] = gameObject;
        }

        return true;
    }

    public void method2055() {
        for (int var1 = 0; var1 < this.tempGameObjectsCount; ++var1) {
            GameObject var2 = this.tempGameObjects[var1];
            this.method2056(var2);
            this.tempGameObjects[var1] = null;
        }

        this.tempGameObjectsCount = 0;
    }

    void method2056(GameObject var1) {
        for (int var2 = var1.startX; var2 <= var1.endX; ++var2) {
            for (int var3 = var1.startY; var3 <= var1.endY; ++var3) {
                Tile var4 = this.tiles[var1.plane][var2][var3];
                if (var4 != null) {
                    int var5;
                    for (var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
                        if (var4.gameObjects[var5] == var1) {
                            --var4.gameObjectsCount;

                            for (int var6 = var5; var6 < var4.gameObjectsCount; ++var6) {
                                var4.gameObjects[var6] = var4.gameObjects[var6 + 1];
                                var4.gameObjectEdgeMasks[var6] = var4.gameObjectEdgeMasks[var6 + 1];
                            }

                            var4.gameObjects[var4.gameObjectsCount] = null;
                            break;
                        }
                    }

                    var4.gameObjectsEdgeMask = 0;

                    for (var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
                        var4.gameObjectsEdgeMask |= var4.gameObjectEdgeMasks[var5];
                    }
                }
            }
        }

    }

    public void method2161(int var1, int var2, int var3, int var4) {
        Tile var5 = this.tiles[var1][var2][var3];
        if (var5 != null) {
            WallDecoration var6 = var5.wallDecoration;
            if (var6 != null) {
                var6.xOffset = var4 * var6.xOffset / 16;
                var6.yOffset = var4 * var6.yOffset / 16;
            }
        }
    }

    public void method2058(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.boundaryObject = null;
        }
    }

    public void method2059(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.wallDecoration = null;
        }
    }

    public void method2043(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            for (int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
                GameObject var6 = var4.gameObjects[var5];
                if ((var6.packedId >> 29 & 3) == 2 && var2 == var6.startX && var3 == var6.startY) {
                    this.method2056(var6);
                    return;
                }
            }

        }
    }

    public void method2184(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.floorDecoration = null;
        }
    }

    public void method2062(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 != null) {
            var4.loot = null;
        }
    }

    public BoundaryObject getBoundaryObject(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 == null ? null : var4.boundaryObject;
    }

    public WallDecoration getWallDecoration(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 == null ? null : var4.wallDecoration;
    }

    public GameObject getGameObject(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 == null) {
            return null;
        } else {
            for (int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
                GameObject var6 = var4.gameObjects[var5];
                if ((var6.packedId >> 29 & 3) == 2 && var2 == var6.startX && var3 == var6.startY) {
                    return var6;
                }
            }

            return null;
        }
    }

    public FloorDecoration method2066(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.floorDecoration != null ? var4.floorDecoration : null;
    }

    public int method2057(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.boundaryObject != null ? var4.boundaryObject.packedId : 0;
    }

    public int method2061(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.wallDecoration != null ? var4.wallDecoration.packedId : 0;
    }

    public int method2069(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        if (var4 == null) {
            return 0;
        } else {
            for (int var5 = 0; var5 < var4.gameObjectsCount; ++var5) {
                GameObject var6 = var4.gameObjects[var5];
                if ((var6.packedId >> 29 & 3) == 2 && var2 == var6.startX && var3 == var6.startY) {
                    return var6.packedId;
                }
            }

            return 0;
        }
    }

    public int method2070(int var1, int var2, int var3) {
        Tile var4 = this.tiles[var1][var2][var3];
        return var4 != null && var4.floorDecoration != null ? var4.floorDecoration.packedId : 0;
    }

    public int method2071(int var1, int var2, int var3, int packedId) {
        Tile tile = this.tiles[var1][var2][var3];
        if (tile == null) {
            return -1;
        } else if (tile.boundaryObject != null && tile.boundaryObject.packedId == packedId) {
            return tile.boundaryObject.flags & 255;
        } else if (tile.wallDecoration != null && tile.wallDecoration.packedId == packedId) {
            return tile.wallDecoration.flags & 255;
        } else if (tile.floorDecoration != null && tile.floorDecoration.packedId == packedId) {
            return tile.floorDecoration.flags & 255;
        } else {
            for (int var6 = 0; var6 < tile.gameObjectsCount; ++var6) {
                if (packedId == tile.gameObjects[var6].packedId) {
                    return tile.gameObjects[var6].flags & 255;
                }
            }

            return -1;
        }
    }

    public void method2072(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < this.planes; ++var4) {
            for (int var5 = 0; var5 < this.xSize; ++var5) {
                for (int var6 = 0; var6 < this.ySize; ++var6) {
                    Tile var7 = this.tiles[var4][var5][var6];
                    if (var7 != null) {
                        BoundaryObject var8 = var7.boundaryObject;
                        ModelData var10;
                        if (var8 != null && var8.renderable1 instanceof ModelData) {
                            ModelData var9 = (ModelData) var8.renderable1;
                            this.method2074(var9, var4, var5, var6, 1, 1);
                            if (var8.renderable2 instanceof ModelData) {
                                var10 = (ModelData) var8.renderable2;
                                this.method2074(var10, var4, var5, var6, 1, 1);
                                ModelData.method2231(var9, var10, 0, 0, 0, false);
                                var8.renderable2 = var10.method2282(var10.ambient, var10.contrast, var1, var2, var3);
                            }

                            var8.renderable1 = var9.method2282(var9.ambient, var9.contrast, var1, var2, var3);
                        }

                        for (int var12 = 0; var12 < var7.gameObjectsCount; ++var12) {
                            GameObject var14 = var7.gameObjects[var12];
                            if (var14 != null && var14.renderable instanceof ModelData) {
                                ModelData var11 = (ModelData) var14.renderable;
                                this.method2074(var11, var4, var5, var6, var14.endX - var14.startX + 1, var14.endY - var14.startY + 1);
                                var14.renderable = var11.method2282(var11.ambient, var11.contrast, var1, var2, var3);
                            }
                        }

                        FloorDecoration var13 = var7.floorDecoration;
                        if (var13 != null && var13.renderable instanceof ModelData) {
                            var10 = (ModelData) var13.renderable;
                            this.method2151(var10, var4, var5, var6);
                            var13.renderable = var10.method2282(var10.ambient, var10.contrast, var1, var2, var3);
                        }
                    }
                }
            }
        }

    }

    void method2151(ModelData var1, int var2, int var3, int var4) {
        Tile var5;
        ModelData var6;
        if (var3 < this.xSize) {
            var5 = this.tiles[var2][var3 + 1][var4];
            if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.renderable instanceof ModelData) {
                var6 = (ModelData) var5.floorDecoration.renderable;
                ModelData.method2231(var1, var6, 128, 0, 0, true);
            }
        }

        if (var4 < this.xSize) {
            var5 = this.tiles[var2][var3][var4 + 1];
            if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.renderable instanceof ModelData) {
                var6 = (ModelData) var5.floorDecoration.renderable;
                ModelData.method2231(var1, var6, 0, 0, 128, true);
            }
        }

        if (var3 < this.xSize && var4 < this.ySize) {
            var5 = this.tiles[var2][var3 + 1][var4 + 1];
            if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.renderable instanceof ModelData) {
                var6 = (ModelData) var5.floorDecoration.renderable;
                ModelData.method2231(var1, var6, 128, 0, 128, true);
            }
        }

        if (var3 < this.xSize && var4 > 0) {
            var5 = this.tiles[var2][var3 + 1][var4 - 1];
            if (var5 != null && var5.floorDecoration != null && var5.floorDecoration.renderable instanceof ModelData) {
                var6 = (ModelData) var5.floorDecoration.renderable;
                ModelData.method2231(var1, var6, 128, 0, -128, true);
            }
        }

    }

    void method2074(ModelData var1, int var2, int var3, int var4, int var5, int var6) {
        boolean var7 = true;
        int var8 = var3;
        int var9 = var3 + var5;
        int var10 = var4 - 1;
        int var11 = var4 + var6;

        for (int var12 = var2; var12 <= var2 + 1; ++var12) {
            if (var12 != this.planes) {
                for (int var13 = var8; var13 <= var9; ++var13) {
                    if (var13 >= 0 && var13 < this.xSize) {
                        for (int var14 = var10; var14 <= var11; ++var14) {
                            if (var14 >= 0 && var14 < this.ySize && (!var7 || var13 >= var9 || var14 >= var11 || var14 < var4 && var3 != var13)) {
                                Tile var15 = this.tiles[var12][var13][var14];
                                if (var15 != null) {
                                    int var16 = (this.tileHeights[var12][var13 + 1][var14] + this.tileHeights[var12][var13 + 1][var14 + 1] + this.tileHeights[var12][var13][var14] + this.tileHeights[var12][var13][var14 + 1]) / 4 - (this.tileHeights[var2][var3 + 1][var4] + this.tileHeights[var2][var3][var4] + this.tileHeights[var2][var3 + 1][var4 + 1] + this.tileHeights[var2][var3][var4 + 1]) / 4;
                                    BoundaryObject var17 = var15.boundaryObject;
                                    if (var17 != null) {
                                        ModelData var18;
                                        if (var17.renderable1 instanceof ModelData) {
                                            var18 = (ModelData) var17.renderable1;
                                            ModelData.method2231(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                                        }

                                        if (var17.renderable2 instanceof ModelData) {
                                            var18 = (ModelData) var17.renderable2;
                                            ModelData.method2231(var1, var18, (1 - var5) * 64 + (var13 - var3) * 128, var16, (var14 - var4) * 128 + (1 - var6) * 64, var7);
                                        }
                                    }

                                    for (int var23 = 0; var23 < var15.gameObjectsCount; ++var23) {
                                        GameObject var19 = var15.gameObjects[var23];
                                        if (var19 != null && var19.renderable instanceof ModelData) {
                                            ModelData var20 = (ModelData) var19.renderable;
                                            int var21 = var19.endX - var19.startX + 1;
                                            int var22 = var19.endY - var19.startY + 1;
                                            ModelData.method2231(var1, var20, (var21 - var5) * 64 + (var19.startX - var3) * 128, var16, (var19.startY - var4) * 128 + (var22 - var6) * 64, var7);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                --var8;
                var7 = false;
            }
        }

    }

    public void method2075(int[] var1, int var2, int var3, int var4, int var5, int var6) {
        Tile var7 = this.tiles[var4][var5][var6];
        if (var7 != null) {
            SceneTilePaint var8 = var7.paint;
            int var10;
            if (var8 != null) {
                int var18 = var8.rgb;
                if (var18 != 0) {
                    for (var10 = 0; var10 < 4; ++var10) {
                        var1[var2] = var18;
                        var1[var2 + 1] = var18;
                        var1[var2 + 2] = var18;
                        var1[var2 + 3] = var18;
                        var2 += var3;
                    }

                }
            } else {
                SceneTileModel var9 = var7.model;
                if (var9 != null) {
                    var10 = var9.shape;
                    int var11 = var9.rotation;
                    int var12 = var9.underlayRgb;
                    int var13 = var9.overlayRgb;
                    int[] var14 = this.tileShape2D[var10];
                    int[] var15 = this.tileRotation2D[var11];
                    int var16 = 0;
                    int var17;
                    if (var12 != 0) {
                        for (var17 = 0; var17 < 4; ++var17) {
                            var1[var2] = var14[var15[var16++]] == 0 ? var12 : var13;
                            var1[var2 + 1] = var14[var15[var16++]] == 0 ? var12 : var13;
                            var1[var2 + 2] = var14[var15[var16++]] == 0 ? var12 : var13;
                            var1[var2 + 3] = var14[var15[var16++]] == 0 ? var12 : var13;
                            var2 += var3;
                        }
                    } else {
                        for (var17 = 0; var17 < 4; ++var17) {
                            if (var14[var15[var16++]] != 0) {
                                var1[var2] = var13;
                            }

                            if (var14[var15[var16++]] != 0) {
                                var1[var2 + 1] = var13;
                            }

                            if (var14[var15[var16++]] != 0) {
                                var1[var2 + 2] = var13;
                            }

                            if (var14[var15[var16++]] != 0) {
                                var1[var2 + 3] = var13;
                            }

                            var2 += var3;
                        }
                    }

                }
            }
        }
    }

    public void method2078(int var1, int var2, int var3) {
        checkClick = true;
        Scene_selectedPlane = var1;
        Scene_selectedScreenX = var2;
        Scene_selectedScreenY = var3;
        Scene_selectedX = -1;
        Scene_selectedY = -1;
    }

    public void method2171(int var1, int var2, int var3, int var4, int var5, int var6) {
        if (var1 < 0) {
            var1 = 0;
        } else if (var1 >= this.xSize * 128) {
            var1 = this.xSize * 128 - 1;
        }

        if (var3 < 0) {
            var3 = 0;
        } else if (var3 >= this.ySize * 128) {
            var3 = this.ySize * 128 - 1;
        }

        ++Scene_drawnCount;
        Scene_cameraPitchSine = Rasterizer3D.Rasterizer3D_sine[var4];
        Scene_cameraPitchCosine = Rasterizer3D.Rasterizer3D_cosine[var4];
        Scene_cameraYawSine = Rasterizer3D.Rasterizer3D_sine[var5];
        Scene_cameraYawCosine = Rasterizer3D.Rasterizer3D_cosine[var5];
        visibleTiles = field1569[(var4 - 128) / 32][var5 / 64];
        Scene_cameraX = var1;
        Scene_cameraY = var2;
        Scene_cameraZ = var3;
        Scene_cameraXTile = var1 / 128;
        Scene_cameraYTile = var3 / 128;
        Scene_plane = var6;
        Scene_cameraXTileMin = Scene_cameraXTile - 25;
        if (Scene_cameraXTileMin < 0) {
            Scene_cameraXTileMin = 0;
        }

        Scene_cameraYTileMin = Scene_cameraYTile - 25;
        if (Scene_cameraYTileMin < 0) {
            Scene_cameraYTileMin = 0;
        }

        Scene_cameraXTileMax = Scene_cameraXTile + 25;
        if (Scene_cameraXTileMax > this.xSize) {
            Scene_cameraXTileMax = this.xSize;
        }

        Scene_cameraYTileMax = Scene_cameraYTile + 25;
        if (Scene_cameraYTileMax > this.ySize) {
            Scene_cameraYTileMax = this.ySize;
        }

        this.method2079();
        tileUpdateCount = 0;

        int var7;
        Tile[][] var8;
        int var9;
        int var10;
        for (var7 = this.minPlane; var7 < this.planes; ++var7) {
            var8 = this.tiles[var7];

            for (var9 = Scene_cameraXTileMin; var9 < Scene_cameraXTileMax; ++var9) {
                for (var10 = Scene_cameraYTileMin; var10 < Scene_cameraYTileMax; ++var10) {
                    Tile var16 = var8[var9][var10];
                    if (var16 != null) {
                        if (var16.minPlane <= var6 && (visibleTiles[var9 - Scene_cameraXTile + 25][var10 - Scene_cameraYTile + 25] || this.tileHeights[var7][var9][var10] - var2 >= 2000)) {
                            var16.drawPrimary = true;
                            var16.drawSecondary = true;
                            var16.drawGameObjects = var16.gameObjectsCount > 0;

                            ++tileUpdateCount;
                        } else {
                            var16.drawPrimary = false;
                            var16.drawSecondary = false;
                            var16.drawGameObjectEdges = 0;
                        }
                    }
                }
            }
        }

        int var11;
        int var12;
        int var13;
        int var14;
        Tile var15;
        for (var7 = this.minPlane; var7 < this.planes; ++var7) {
            var8 = this.tiles[var7];

            for (var9 = -25; var9 <= 0; ++var9) {
                var10 = var9 + Scene_cameraXTile;
                var11 = Scene_cameraXTile - var9;
                if (var10 >= Scene_cameraXTileMin || var11 < Scene_cameraXTileMax) {
                    for (var12 = -25; var12 <= 0; ++var12) {
                        var13 = var12 + Scene_cameraYTile;
                        var14 = Scene_cameraYTile - var12;
                        if (var10 >= Scene_cameraXTileMin) {
                            if (var13 >= Scene_cameraYTileMin) {
                                var15 = var8[var10][var13];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, true);
                                }
                            }

                            if (var14 < Scene_cameraYTileMax) {
                                var15 = var8[var10][var14];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, true);
                                }
                            }
                        }

                        if (var11 < Scene_cameraXTileMax) {
                            if (var13 >= Scene_cameraYTileMin) {
                                var15 = var8[var11][var13];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, true);
                                }
                            }

                            if (var14 < Scene_cameraYTileMax) {
                                var15 = var8[var11][var14];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, true);
                                }
                            }
                        }

                        if (tileUpdateCount == 0) {
                            checkClick = false;
                            return;
                        }
                    }
                }
            }
        }

        for (var7 = this.minPlane; var7 < this.planes; ++var7) {
            var8 = this.tiles[var7];

            for (var9 = -25; var9 <= 0; ++var9) {
                var10 = var9 + Scene_cameraXTile;
                var11 = Scene_cameraXTile - var9;
                if (var10 >= Scene_cameraXTileMin || var11 < Scene_cameraXTileMax) {
                    for (var12 = -25; var12 <= 0; ++var12) {
                        var13 = var12 + Scene_cameraYTile;
                        var14 = Scene_cameraYTile - var12;
                        if (var10 >= Scene_cameraXTileMin) {
                            if (var13 >= Scene_cameraYTileMin) {
                                var15 = var8[var10][var13];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, false);
                                }
                            }

                            if (var14 < Scene_cameraYTileMax) {
                                var15 = var8[var10][var14];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, false);
                                }
                            }
                        }

                        if (var11 < Scene_cameraXTileMax) {
                            if (var13 >= Scene_cameraYTileMin) {
                                var15 = var8[var11][var13];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, false);
                                }
                            }

                            if (var14 < Scene_cameraYTileMax) {
                                var15 = var8[var11][var14];
                                if (var15 != null && var15.drawPrimary) {
                                    this.method2080(var15, false);
                                }
                            }
                        }

                        if (tileUpdateCount == 0) {
                            checkClick = false;
                            return;
                        }
                    }
                }
            }
        }

        checkClick = false;
    }

    void method2080(Tile var1, boolean var2) {
        Scene_tilesDeque.method3528(var1);

        while (true) {
            Tile var3;
            int var4;
            int var5;
            int var6;
            int var7;
            Tile[][] var8;
            Tile var9;
            int var11;
            int var14;
            int var15;
            int var16;
            int var24;
            int var25;
            do {
                do {
                    do {
                        do {
                            do {
                                do {
                                    while (true) {
                                        BoundaryObject var10;
                                        GameObject var12;
                                        int var17;
                                        int var18;
                                        boolean var20;
                                        int var21;
                                        Tile var36;
                                        while (true) {
                                            do {
                                                var3 = (Tile) Scene_tilesDeque.method3549();
                                                if (var3 == null) {
                                                    return;
                                                }
                                            } while (!var3.drawSecondary);

                                            var4 = var3.x;
                                            var5 = var3.y;
                                            var6 = var3.plane;
                                            var7 = var3.originalPlane;
                                            var8 = this.tiles[var6];
                                            if (!var3.drawPrimary) {
                                                break;
                                            }

                                            if (var2) {
                                                if (var6 > 0) {
                                                    var9 = this.tiles[var6 - 1][var4][var5];
                                                    if (var9 != null && var9.drawSecondary) {
                                                        continue;
                                                    }
                                                }

                                                if (var4 <= Scene_cameraXTile && var4 > Scene_cameraXTileMin) {
                                                    var9 = var8[var4 - 1][var5];
                                                    if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 1) == 0)) {
                                                        continue;
                                                    }
                                                }

                                                if (var4 >= Scene_cameraXTile && var4 < Scene_cameraXTileMax - 1) {
                                                    var9 = var8[var4 + 1][var5];
                                                    if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 4) == 0)) {
                                                        continue;
                                                    }
                                                }

                                                if (var5 <= Scene_cameraYTile && var5 > Scene_cameraYTileMin) {
                                                    var9 = var8[var4][var5 - 1];
                                                    if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 8) == 0)) {
                                                        continue;
                                                    }
                                                }

                                                if (var5 >= Scene_cameraYTile && var5 < Scene_cameraYTileMax - 1) {
                                                    var9 = var8[var4][var5 + 1];
                                                    if (var9 != null && var9.drawSecondary && (var9.drawPrimary || (var3.gameObjectsEdgeMask & 2) == 0)) {
                                                        continue;
                                                    }
                                                }
                                            } else {
                                                var2 = true;
                                            }

                                            var3.drawPrimary = false;
                                            if (var3.linkedBelowTile != null) {
                                                var9 = var3.linkedBelowTile;
                                                if (var9.paint != null) {
                                                    if (!this.method2086(0, var4, var5)) {
                                                        this.method2081(var9.paint, 0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
                                                    }
                                                } else if (var9.model != null && !this.method2086(0, var4, var5)) {
                                                    this.method2172(var9.model, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
                                                }

                                                var10 = var9.boundaryObject;
                                                if (var10 != null) {
                                                    var10.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var10.x - Scene_cameraX, var10.tileHeight - Scene_cameraY, var10.y - Scene_cameraZ, var10.packedId);
                                                }

                                                for (var11 = 0; var11 < var9.gameObjectsCount; ++var11) {
                                                    var12 = var9.gameObjects[var11];
                                                    if (var12 != null) {
                                                        var12.renderable.vmethod2441(var12.field1645, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var12.centerX - Scene_cameraX, var12.height - Scene_cameraY, var12.centerY - Scene_cameraZ, var12.packedId);
                                                    }
                                                }
                                            }

                                            var20 = false;
                                            if (var3.paint != null) {
                                                if (!this.method2086(var7, var4, var5)) {
                                                    var20 = true;
                                                    if (var3.paint.neColor != 12345678 || checkClick && var6 <= Scene_selectedPlane) {
                                                        this.method2081(var3.paint, var7, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
                                                    }
                                                }
                                            } else if (var3.model != null && !this.method2086(var7, var4, var5)) {
                                                var20 = true;
                                                this.method2172(var3.model, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var4, var5);
                                            }

                                            var21 = 0;
                                            var11 = 0;
                                            BoundaryObject var31 = var3.boundaryObject;
                                            WallDecoration var13 = var3.wallDecoration;
                                            if (var31 != null || var13 != null) {
                                                if (var4 == Scene_cameraXTile) {
                                                    ++var21;
                                                } else if (Scene_cameraXTile < var4) {
                                                    var21 += 2;
                                                }

                                                if (var5 == Scene_cameraYTile) {
                                                    var21 += 3;
                                                } else if (Scene_cameraYTile > var5) {
                                                    var21 += 6;
                                                }

                                                var11 = field1595[var21];
                                                var3.field1754 = field1583[var21];
                                            }

                                            if (var31 != null) {
                                                if ((var31.orientationA & field1596[var21]) != 0) {
                                                    if (var31.orientationA == 16) {
                                                        var3.drawGameObjectEdges = 3;
                                                        var3.field1752 = field1598[var21];
                                                        var3.field1753 = 3 - var3.field1752;
                                                    } else if (var31.orientationA == 32) {
                                                        var3.drawGameObjectEdges = 6;
                                                        var3.field1752 = field1599[var21];
                                                        var3.field1753 = 6 - var3.field1752;
                                                    } else if (var31.orientationA == 64) {
                                                        var3.drawGameObjectEdges = 12;
                                                        var3.field1752 = field1600[var21];
                                                        var3.field1753 = 12 - var3.field1752;
                                                    } else {
                                                        var3.drawGameObjectEdges = 9;
                                                        var3.field1752 = field1601[var21];
                                                        var3.field1753 = 9 - var3.field1752;
                                                    }
                                                } else {
                                                    var3.drawGameObjectEdges = 0;
                                                }

                                                if ((var31.orientationA & var11) != 0 && !this.method2087(var7, var4, var5, var31.orientationA)) {
                                                    var31.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var31.x - Scene_cameraX, var31.tileHeight - Scene_cameraY, var31.y - Scene_cameraZ, var31.packedId);
                                                }

                                                if ((var31.orientationB & var11) != 0 && !this.method2087(var7, var4, var5, var31.orientationB)) {
                                                    var31.renderable2.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var31.x - Scene_cameraX, var31.tileHeight - Scene_cameraY, var31.y - Scene_cameraZ, var31.packedId);
                                                }
                                            }

                                            if (var13 != null && !this.method2088(var7, var4, var5, var13.renderable1.height)) {
                                                if ((var13.orientation & var11) != 0) {
                                                    var13.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var13.x - Scene_cameraX + var13.xOffset, var13.tileHeight - Scene_cameraY, var13.y - Scene_cameraZ + var13.yOffset, var13.packedId);
                                                } else if (var13.orientation == 256) {
                                                    var14 = var13.x - Scene_cameraX;
                                                    var15 = var13.tileHeight - Scene_cameraY;
                                                    var16 = var13.y - Scene_cameraZ;
                                                    var17 = var13.orientation2;
                                                    if (var17 != 1 && var17 != 2) {
                                                        var18 = var14;
                                                    } else {
                                                        var18 = -var14;
                                                    }

                                                    int var19;
                                                    if (var17 != 2 && var17 != 3) {
                                                        var19 = var16;
                                                    } else {
                                                        var19 = -var16;
                                                    }

                                                    if (var19 < var18) {
                                                        var13.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var14 + var13.xOffset, var15, var16 + var13.yOffset, var13.packedId);
                                                    } else if (var13.renderable2 != null) {
                                                        var13.renderable2.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var14, var15, var16, var13.packedId);
                                                    }
                                                }
                                            }

                                            if (var20) {
                                                FloorDecoration var22 = var3.floorDecoration;
                                                if (var22 != null) {
                                                    var22.renderable.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var22.x - Scene_cameraX, var22.tileHeight - Scene_cameraY, var22.y - Scene_cameraZ, var22.packedId);
                                                }

                                                Loot var23 = var3.loot;
                                                if (var23 != null && var23.height == 0) {
                                                    if (var23.drawnLayer2 != null) {
                                                        var23.drawnLayer2.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y - Scene_cameraZ, var23.field1664);
                                                    }

                                                    if (var23.drawnLayer3 != null) {
                                                        var23.drawnLayer3.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y - Scene_cameraZ, var23.field1664);
                                                    }

                                                    if (var23.drawnLayer1 != null) {
                                                        var23.drawnLayer1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var23.x - Scene_cameraX, var23.tileHeight - Scene_cameraY, var23.y - Scene_cameraZ, var23.field1664);
                                                    }
                                                }
                                            }

                                            var14 = var3.gameObjectsEdgeMask;
                                            if (var14 != 0) {
                                                if (var4 < Scene_cameraXTile && (var14 & 4) != 0) {
                                                    var36 = var8[var4 + 1][var5];
                                                    if (var36 != null && var36.drawSecondary) {
                                                        Scene_tilesDeque.method3528(var36);
                                                    }
                                                }

                                                if (var5 < Scene_cameraYTile && (var14 & 2) != 0) {
                                                    var36 = var8[var4][var5 + 1];
                                                    if (var36 != null && var36.drawSecondary) {
                                                        Scene_tilesDeque.method3528(var36);
                                                    }
                                                }

                                                if (var4 > Scene_cameraXTile && (var14 & 1) != 0) {
                                                    var36 = var8[var4 - 1][var5];
                                                    if (var36 != null && var36.drawSecondary) {
                                                        Scene_tilesDeque.method3528(var36);
                                                    }
                                                }

                                                if (var5 > Scene_cameraYTile && (var14 & 8) != 0) {
                                                    var36 = var8[var4][var5 - 1];
                                                    if (var36 != null && var36.drawSecondary) {
                                                        Scene_tilesDeque.method3528(var36);
                                                    }
                                                }
                                            }
                                            break;
                                        }

                                        if (var3.drawGameObjectEdges != 0) {
                                            var20 = true;

                                            for (var21 = 0; var21 < var3.gameObjectsCount; ++var21) {
                                                if (var3.gameObjects[var21].lastDrawn != Scene_drawnCount && (var3.gameObjectEdgeMasks[var21] & var3.drawGameObjectEdges) == var3.field1752) {
                                                    var20 = false;
                                                    break;
                                                }
                                            }

                                            if (var20) {
                                                var10 = var3.boundaryObject;
                                                if (!this.method2087(var7, var4, var5, var10.orientationA)) {
                                                    var10.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var10.x - Scene_cameraX, var10.tileHeight - Scene_cameraY, var10.y - Scene_cameraZ, var10.packedId);
                                                }

                                                var3.drawGameObjectEdges = 0;
                                            }
                                        }

                                        if (!var3.drawGameObjects) {
                                            break;
                                        }

                                        try {
                                            int var34 = var3.gameObjectsCount;
                                            var3.drawGameObjects = false;
                                            var21 = 0;

                                            label563:
                                            for (var11 = 0; var11 < var34; ++var11) {
                                                var12 = var3.gameObjects[var11];
                                                if (var12.lastDrawn != Scene_drawnCount) {
                                                    for (var24 = var12.startX; var24 <= var12.endX; ++var24) {
                                                        for (var14 = var12.startY; var14 <= var12.endY; ++var14) {
                                                            var36 = var8[var24][var14];
                                                            if (var36.drawPrimary) {
                                                                var3.drawGameObjects = true;
                                                                continue label563;
                                                            }

                                                            if (var36.drawGameObjectEdges != 0) {
                                                                var16 = 0;
                                                                if (var24 > var12.startX) {
                                                                    ++var16;
                                                                }

                                                                if (var24 < var12.endX) {
                                                                    var16 += 4;
                                                                }

                                                                if (var14 > var12.startY) {
                                                                    var16 += 8;
                                                                }

                                                                if (var14 < var12.endY) {
                                                                    var16 += 2;
                                                                }

                                                                if ((var16 & var36.drawGameObjectEdges) == var3.field1753) {
                                                                    var3.drawGameObjects = true;
                                                                    continue label563;
                                                                }
                                                            }
                                                        }
                                                    }

                                                    gameObjects[var21++] = var12;
                                                    var24 = Scene_cameraXTile - var12.startX;
                                                    var14 = var12.endX - Scene_cameraXTile;
                                                    if (var14 > var24) {
                                                        var24 = var14;
                                                    }

                                                    var15 = Scene_cameraYTile - var12.startY;
                                                    var16 = var12.endY - Scene_cameraYTile;
                                                    if (var16 > var15) {
                                                        var12.field1650 = var24 + var16;
                                                    } else {
                                                        var12.field1650 = var24 + var15;
                                                    }
                                                }
                                            }

                                            while (var21 > 0) {
                                                var11 = -50;
                                                var25 = -1;

                                                for (var24 = 0; var24 < var21; ++var24) {
                                                    GameObject var35 = gameObjects[var24];
                                                    if (var35.lastDrawn != Scene_drawnCount) {
                                                        if (var35.field1650 > var11) {
                                                            var11 = var35.field1650;
                                                            var25 = var24;
                                                        } else if (var11 == var35.field1650) {
                                                            var15 = var35.centerX - Scene_cameraX;
                                                            var16 = var35.centerY - Scene_cameraZ;
                                                            var17 = gameObjects[var25].centerX - Scene_cameraX;
                                                            var18 = gameObjects[var25].centerY - Scene_cameraZ;
                                                            if (var15 * var15 + var16 * var16 > var17 * var17 + var18 * var18) {
                                                                var25 = var24;
                                                            }
                                                        }
                                                    }
                                                }

                                                if (var25 == -1) {
                                                    break;
                                                }

                                                GameObject var33 = gameObjects[var25];
                                                var33.lastDrawn = Scene_drawnCount;
                                                if (!this.method2089(var7, var33.startX, var33.endX, var33.startY, var33.endY, var33.renderable.height)) {
                                                    var33.renderable.vmethod2441(var33.field1645, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var33.centerX - Scene_cameraX, var33.height - Scene_cameraY, var33.centerY - Scene_cameraZ, var33.packedId);
                                                }

                                                for (var14 = var33.startX; var14 <= var33.endX; ++var14) {
                                                    for (var15 = var33.startY; var15 <= var33.endY; ++var15) {
                                                        Tile var26 = var8[var14][var15];
                                                        if (var26.drawGameObjectEdges != 0) {
                                                            Scene_tilesDeque.method3528(var26);
                                                        } else if ((var14 != var4 || var15 != var5) && var26.drawSecondary) {
                                                            Scene_tilesDeque.method3528(var26);
                                                        }
                                                    }
                                                }
                                            }

                                            if (!var3.drawGameObjects) {
                                                break;
                                            }
                                        } catch (Exception var28) {
                                            var3.drawGameObjects = false;
                                            break;
                                        }
                                    }
                                } while (!var3.drawSecondary);
                            } while (var3.drawGameObjectEdges != 0);

                            if (var4 > Scene_cameraXTile || var4 <= Scene_cameraXTileMin) {
                                break;
                            }

                            var9 = var8[var4 - 1][var5];
                        } while (var9 != null && var9.drawSecondary);

                        if (var4 < Scene_cameraXTile || var4 >= Scene_cameraXTileMax - 1) {
                            break;
                        }

                        var9 = var8[var4 + 1][var5];
                    } while (var9 != null && var9.drawSecondary);

                    if (var5 > Scene_cameraYTile || var5 <= Scene_cameraYTileMin) {
                        break;
                    }

                    var9 = var8[var4][var5 - 1];
                } while (var9 != null && var9.drawSecondary);

                if (var5 < Scene_cameraYTile || var5 >= Scene_cameraYTileMax - 1) {
                    break;
                }

                var9 = var8[var4][var5 + 1];
            } while (var9 != null && var9.drawSecondary);

            var3.drawSecondary = false;
            --tileUpdateCount;
            Loot var32 = var3.loot;
            if (var32 != null && var32.height != 0) {
                if (var32.drawnLayer2 != null) {
                    var32.drawnLayer2.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y - Scene_cameraZ, var32.field1664);
                }

                if (var32.drawnLayer3 != null) {
                    var32.drawnLayer3.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y - Scene_cameraZ, var32.field1664);
                }

                if (var32.drawnLayer1 != null) {
                    var32.drawnLayer1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var32.x - Scene_cameraX, var32.tileHeight - Scene_cameraY - var32.height, var32.y - Scene_cameraZ, var32.field1664);
                }
            }

            if (var3.field1754 != 0) {
                WallDecoration var29 = var3.wallDecoration;
                if (var29 != null && !this.method2088(var7, var4, var5, var29.renderable1.height)) {
                    if ((var29.orientation & var3.field1754) != 0) {
                        var29.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var29.x - Scene_cameraX + var29.xOffset, var29.tileHeight - Scene_cameraY, var29.y - Scene_cameraZ + var29.yOffset, var29.packedId);
                    } else if (var29.orientation == 256) {
                        var11 = var29.x - Scene_cameraX;
                        var25 = var29.tileHeight - Scene_cameraY;
                        var24 = var29.y - Scene_cameraZ;
                        var14 = var29.orientation2;
                        if (var14 != 1 && var14 != 2) {
                            var15 = var11;
                        } else {
                            var15 = -var11;
                        }

                        if (var14 != 2 && var14 != 3) {
                            var16 = var24;
                        } else {
                            var16 = -var24;
                        }

                        if (var16 >= var15) {
                            var29.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var11 + var29.xOffset, var25, var24 + var29.yOffset, var29.packedId);
                        } else if (var29.renderable2 != null) {
                            var29.renderable2.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var11, var25, var24, var29.packedId);
                        }
                    }
                }

                BoundaryObject var27 = var3.boundaryObject;
                if (var27 != null) {
                    if ((var27.orientationB & var3.field1754) != 0 && !this.method2087(var7, var4, var5, var27.orientationB)) {
                        var27.renderable2.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var27.x - Scene_cameraX, var27.tileHeight - Scene_cameraY, var27.y - Scene_cameraZ, var27.packedId);
                    }

                    if ((var27.orientationA & var3.field1754) != 0 && !this.method2087(var7, var4, var5, var27.orientationA)) {
                        var27.renderable1.vmethod2441(0, Scene_cameraPitchSine, Scene_cameraPitchCosine, Scene_cameraYawSine, Scene_cameraYawCosine, var27.x - Scene_cameraX, var27.tileHeight - Scene_cameraY, var27.y - Scene_cameraZ, var27.packedId);
                    }
                }
            }

            Tile var30;
            if (var6 < this.planes - 1) {
                var30 = this.tiles[var6 + 1][var4][var5];
                if (var30 != null && var30.drawSecondary) {
                    Scene_tilesDeque.method3528(var30);
                }
            }

            if (var4 < Scene_cameraXTile) {
                var30 = var8[var4 + 1][var5];
                if (var30 != null && var30.drawSecondary) {
                    Scene_tilesDeque.method3528(var30);
                }
            }

            if (var5 < Scene_cameraYTile) {
                var30 = var8[var4][var5 + 1];
                if (var30 != null && var30.drawSecondary) {
                    Scene_tilesDeque.method3528(var30);
                }
            }

            if (var4 > Scene_cameraXTile) {
                var30 = var8[var4 - 1][var5];
                if (var30 != null && var30.drawSecondary) {
                    Scene_tilesDeque.method3528(var30);
                }
            }

            if (var5 > Scene_cameraYTile) {
                var30 = var8[var4][var5 - 1];
                if (var30 != null && var30.drawSecondary) {
                    Scene_tilesDeque.method3528(var30);
                }
            }
        }
    }

    void method2081(SceneTilePaint var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        int var9;
        int var10 = var9 = (var7 << 7) - Scene_cameraX;
        int var11;
        int var12 = var11 = (var8 << 7) - Scene_cameraZ;
        int var13;
        int var14 = var13 = var10 + 128;
        int var15;
        int var16 = var15 = var12 + 128;
        int var17 = this.tileHeights[var2][var7][var8] - Scene_cameraY;
        int var18 = this.tileHeights[var2][var7 + 1][var8] - Scene_cameraY;
        int var19 = this.tileHeights[var2][var7 + 1][var8 + 1] - Scene_cameraY;
        int var20 = this.tileHeights[var2][var7][var8 + 1] - Scene_cameraY;
        int var21 = var10 * var6 + var5 * var12 >> 16;
        var12 = var12 * var6 - var5 * var10 >> 16;
        var10 = var21;
        var21 = var17 * var4 - var3 * var12 >> 16;
        var12 = var3 * var17 + var12 * var4 >> 16;
        var17 = var21;
        if (var12 >= 50) {
            var21 = var14 * var6 + var5 * var11 >> 16;
            var11 = var11 * var6 - var5 * var14 >> 16;
            var14 = var21;
            var21 = var18 * var4 - var3 * var11 >> 16;
            var11 = var3 * var18 + var11 * var4 >> 16;
            var18 = var21;
            if (var11 >= 50) {
                var21 = var13 * var6 + var5 * var16 >> 16;
                var16 = var16 * var6 - var5 * var13 >> 16;
                var13 = var21;
                var21 = var19 * var4 - var3 * var16 >> 16;
                var16 = var3 * var19 + var16 * var4 >> 16;
                var19 = var21;
                if (var16 >= 50) {
                    var21 = var9 * var6 + var5 * var15 >> 16;
                    var15 = var15 * var6 - var5 * var9 >> 16;
                    var9 = var21;
                    var21 = var20 * var4 - var3 * var15 >> 16;
                    var15 = var3 * var20 + var15 * var4 >> 16;
                    if (var15 >= 50) {
                        int var22 = (var10 << 9) / var12 + Rasterizer3D.Rasterizer3D_clipMidX;
                        int var23 = (var17 << 9) / var12 + Rasterizer3D.Rasterizer3D_clipMidY;
                        int var24 = (var14 << 9) / var11 + Rasterizer3D.Rasterizer3D_clipMidX;
                        int var25 = (var18 << 9) / var11 + Rasterizer3D.Rasterizer3D_clipMidY;
                        int var26 = (var13 << 9) / var16 + Rasterizer3D.Rasterizer3D_clipMidX;
                        int var27 = (var19 << 9) / var16 + Rasterizer3D.Rasterizer3D_clipMidY;
                        int var28 = (var9 << 9) / var15 + Rasterizer3D.Rasterizer3D_clipMidX;
                        int var29 = (var21 << 9) / var15 + Rasterizer3D.Rasterizer3D_clipMidY;
                        Rasterizer3D.Rasterizer3D_alpha = 0;
                        int var30;
                        if ((var26 - var28) * (var25 - var29) - (var27 - var29) * (var24 - var28) > 0) {
                            Rasterizer3D.field1777 = var26 < 0 || var28 < 0 || var24 < 0 || var26 > Rasterizer3D.Rasterizer3D_clipWidth || var28 > Rasterizer3D.Rasterizer3D_clipWidth || var24 > Rasterizer3D.Rasterizer3D_clipWidth;

                            if (checkClick && this.method2084(Scene_selectedScreenX, Scene_selectedScreenY, var27, var29, var25, var26, var28, var24)) {
                                Scene_selectedX = var7;
                                Scene_selectedY = var8;
                            }

                            if (var1.texture == -1) {
                                if (var1.neColor != 12345678) {
                                    Rasterizer3D.method2311(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor);
                                }
                            } else if (!Scene_isLowDetail) {
                                if (var1.isFlat) {
                                    Rasterizer3D.method2317(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                                } else {
                                    Rasterizer3D.method2317(var27, var29, var25, var26, var28, var24, var1.neColor, var1.nwColor, var1.seColor, var13, var9, var14, var19, var21, var18, var16, var15, var11, var1.texture);
                                }
                            } else {
                                var30 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod2406(var1.texture);
                                Rasterizer3D.method2311(var27, var29, var25, var26, var28, var24, method2113(var30, var1.neColor), method2113(var30, var1.nwColor), method2113(var30, var1.seColor));
                            }
                        }

                        if ((var22 - var24) * (var29 - var25) - (var23 - var25) * (var28 - var24) > 0) {
                            Rasterizer3D.field1777 = var22 < 0 || var24 < 0 || var28 < 0 || var22 > Rasterizer3D.Rasterizer3D_clipWidth || var24 > Rasterizer3D.Rasterizer3D_clipWidth || var28 > Rasterizer3D.Rasterizer3D_clipWidth;

                            if (checkClick && this.method2084(Scene_selectedScreenX, Scene_selectedScreenY, var23, var25, var29, var22, var24, var28)) {
                                Scene_selectedX = var7;
                                Scene_selectedY = var8;
                            }

                            if (var1.texture == -1) {
                                if (var1.swColor != 12345678) {
                                    Rasterizer3D.method2311(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor);
                                }
                            } else if (!Scene_isLowDetail) {
                                Rasterizer3D.method2317(var23, var25, var29, var22, var24, var28, var1.swColor, var1.seColor, var1.nwColor, var10, var14, var9, var17, var18, var21, var12, var11, var15, var1.texture);
                            } else {
                                var30 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod2406(var1.texture);
                                Rasterizer3D.method2311(var23, var25, var29, var22, var24, var28, method2113(var30, var1.swColor), method2113(var30, var1.seColor), method2113(var30, var1.nwColor));
                            }
                        }

                    }
                }
            }
        }
    }

    void method2172(SceneTileModel var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        int var8 = var1.vertexX.length;

        int var9;
        int var10;
        int var11;
        int var12;
        int var13;
        for (var9 = 0; var9 < var8; ++var9) {
            var10 = var1.vertexX[var9] - Scene_cameraX;
            var11 = var1.vertexY[var9] - Scene_cameraY;
            var12 = var1.vertexZ[var9] - Scene_cameraZ;
            var13 = var12 * var4 + var5 * var10 >> 16;
            var12 = var5 * var12 - var10 * var4 >> 16;
            var10 = var13;
            var13 = var3 * var11 - var12 * var2 >> 16;
            var12 = var11 * var2 + var3 * var12 >> 16;
            if (var12 < 50) {
                return;
            }

            if (var1.triangleTextureId != null) {
                SceneTileModel.field1541[var9] = var10;
                SceneTileModel.field1536[var9] = var13;
                SceneTileModel.field1543[var9] = var12;
            }

            SceneTileModel.field1540[var9] = (var10 << 9) / var12 + Rasterizer3D.Rasterizer3D_clipMidX;
            SceneTileModel.field1535[var9] = (var13 << 9) / var12 + Rasterizer3D.Rasterizer3D_clipMidY;
        }

        Rasterizer3D.Rasterizer3D_alpha = 0;
        var8 = var1.faceX.length;

        for (var9 = 0; var9 < var8; ++var9) {
            var10 = var1.faceX[var9];
            var11 = var1.faceY[var9];
            var12 = var1.faceZ[var9];
            var13 = SceneTileModel.field1540[var10];
            int var14 = SceneTileModel.field1540[var11];
            int var15 = SceneTileModel.field1540[var12];
            int var16 = SceneTileModel.field1535[var10];
            int var17 = SceneTileModel.field1535[var11];
            int var18 = SceneTileModel.field1535[var12];
            if ((var13 - var14) * (var18 - var17) - (var16 - var17) * (var15 - var14) > 0) {
                Rasterizer3D.field1777 = var13 < 0 || var14 < 0 || var15 < 0 || var13 > Rasterizer3D.Rasterizer3D_clipWidth || var14 > Rasterizer3D.Rasterizer3D_clipWidth || var15 > Rasterizer3D.Rasterizer3D_clipWidth;

                if (checkClick && this.method2084(Scene_selectedScreenX, Scene_selectedScreenY, var16, var17, var18, var13, var14, var15)) {
                    Scene_selectedX = var6;
                    Scene_selectedY = var7;
                }

                if (var1.triangleTextureId != null && var1.triangleTextureId[var9] != -1) {
                    if (!Scene_isLowDetail) {
                        if (var1.isFlat) {
                            Rasterizer3D.method2317(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], SceneTileModel.field1541[0], SceneTileModel.field1541[1], SceneTileModel.field1541[3], SceneTileModel.field1536[0], SceneTileModel.field1536[1], SceneTileModel.field1536[3], SceneTileModel.field1543[0], SceneTileModel.field1543[1], SceneTileModel.field1543[3], var1.triangleTextureId[var9]);
                        } else {
                            Rasterizer3D.method2317(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9], SceneTileModel.field1541[var10], SceneTileModel.field1541[var11], SceneTileModel.field1541[var12], SceneTileModel.field1536[var10], SceneTileModel.field1536[var11], SceneTileModel.field1536[var12], SceneTileModel.field1543[var10], SceneTileModel.field1543[var11], SceneTileModel.field1543[var12], var1.triangleTextureId[var9]);
                        }
                    } else {
                        int var19 = Rasterizer3D.Rasterizer3D_textureLoader.vmethod2406(var1.triangleTextureId[var9]);
                        Rasterizer3D.method2311(var16, var17, var18, var13, var14, var15, method2113(var19, var1.triangleColorA[var9]), method2113(var19, var1.triangleColorB[var9]), method2113(var19, var1.triangleColorC[var9]));
                    }
                } else if (var1.triangleColorA[var9] != 12345678) {
                    Rasterizer3D.method2311(var16, var17, var18, var13, var14, var15, var1.triangleColorA[var9], var1.triangleColorB[var9], var1.triangleColorC[var9]);
                }
            }
        }

    }

    boolean method2084(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
        if (var2 < var3 && var2 < var4 && var2 < var5) {
            return false;
        } else if (var2 > var3 && var2 > var4 && var2 > var5) {
            return false;
        } else if (var1 < var6 && var1 < var7 && var1 < var8) {
            return false;
        } else if (var1 > var6 && var1 > var7 && var1 > var8) {
            return false;
        } else {
            int var9 = (var2 - var3) * (var7 - var6) - (var1 - var6) * (var4 - var3);
            int var10 = (var6 - var8) * (var2 - var5) - (var1 - var8) * (var3 - var5);
            int var11 = (var8 - var7) * (var2 - var4) - (var1 - var7) * (var5 - var4);
            return var9 * var11 > 0 && var11 * var10 > 0;
        }
    }

    void method2079() {
        int var1 = Scene_planeOccluderCounts[Scene_plane];
        Occluder[] var2 = Scene_planeOccluders[Scene_plane];
        Scene_currentOccludersCount = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            Occluder var4 = var2[var3];
            int var5;
            int var6;
            int var7;
            int var9;
            boolean var13;
            if (var4.type == 1) {
                var5 = var4.minTileX - Scene_cameraXTile + 25;
                if (var5 >= 0 && var5 <= 50) {
                    var6 = var4.minTileY - Scene_cameraYTile + 25;
                    if (var6 < 0) {
                        var6 = 0;
                    }

                    var7 = var4.maxTileY - Scene_cameraYTile + 25;
                    if (var7 > 50) {
                        var7 = 50;
                    }

                    var13 = false;

                    while (var6 <= var7) {
                        if (visibleTiles[var5][var6++]) {
                            var13 = true;
                            break;
                        }
                    }

                    if (var13) {
                        var9 = Scene_cameraX - var4.minX;
                        if (var9 > 32) {
                            var4.field1852 = 1;
                        } else {
                            if (var9 >= -32) {
                                continue;
                            }

                            var4.field1852 = 2;
                            var9 = -var9;
                        }

                        var4.field1855 = (var4.minZ - Scene_cameraZ << 8) / var9;
                        var4.field1856 = (var4.maxZ - Scene_cameraZ << 8) / var9;
                        var4.field1857 = (var4.minY - Scene_cameraY << 8) / var9;
                        var4.field1861 = (var4.maxY - Scene_cameraY << 8) / var9;
                        Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
                    }
                }
            } else if (var4.type == 2) {
                var5 = var4.minTileY - Scene_cameraYTile + 25;
                if (var5 >= 0 && var5 <= 50) {
                    var6 = var4.minTileX - Scene_cameraXTile + 25;
                    if (var6 < 0) {
                        var6 = 0;
                    }

                    var7 = var4.maxTileX - Scene_cameraXTile + 25;
                    if (var7 > 50) {
                        var7 = 50;
                    }

                    var13 = false;

                    while (var6 <= var7) {
                        if (visibleTiles[var6++][var5]) {
                            var13 = true;
                            break;
                        }
                    }

                    if (var13) {
                        var9 = Scene_cameraZ - var4.minZ;
                        if (var9 > 32) {
                            var4.field1852 = 3;
                        } else {
                            if (var9 >= -32) {
                                continue;
                            }

                            var4.field1852 = 4;
                            var9 = -var9;
                        }

                        var4.field1842 = (var4.minX - Scene_cameraX << 8) / var9;
                        var4.field1854 = (var4.maxX - Scene_cameraX << 8) / var9;
                        var4.field1857 = (var4.minY - Scene_cameraY << 8) / var9;
                        var4.field1861 = (var4.maxY - Scene_cameraY << 8) / var9;
                        Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
                    }
                }
            } else if (var4.type == 4) {
                var5 = var4.minY - Scene_cameraY;
                if (var5 > 128) {
                    var6 = var4.minTileY - Scene_cameraYTile + 25;
                    if (var6 < 0) {
                        var6 = 0;
                    }

                    var7 = var4.maxTileY - Scene_cameraYTile + 25;
                    if (var7 > 50) {
                        var7 = 50;
                    }

                    if (var6 <= var7) {
                        int var8 = var4.minTileX - Scene_cameraXTile + 25;
                        if (var8 < 0) {
                            var8 = 0;
                        }

                        var9 = var4.maxTileX - Scene_cameraXTile + 25;
                        if (var9 > 50) {
                            var9 = 50;
                        }

                        boolean var10 = false;

                        label148:
                        for (int var11 = var8; var11 <= var9; ++var11) {
                            for (int var12 = var6; var12 <= var7; ++var12) {
                                if (visibleTiles[var11][var12]) {
                                    var10 = true;
                                    break label148;
                                }
                            }
                        }

                        if (var10) {
                            var4.field1852 = 5;
                            var4.field1842 = (var4.minX - Scene_cameraX << 8) / var5;
                            var4.field1854 = (var4.maxX - Scene_cameraX << 8) / var5;
                            var4.field1855 = (var4.minZ - Scene_cameraZ << 8) / var5;
                            var4.field1856 = (var4.maxZ - Scene_cameraZ << 8) / var5;
                            Scene_currentOccluders[Scene_currentOccludersCount++] = var4;
                        }
                    }
                }
            }
        }

    }

    boolean method2086(int var1, int var2, int var3) {
        int var4 = this.field1558[var1][var2][var3];
        if (var4 == -Scene_drawnCount) {
            return false;
        } else if (var4 == Scene_drawnCount) {
            return true;
        } else {
            int var5 = var2 << 7;
            int var6 = var3 << 7;
            if (this.method2153(var5 + 1, this.tileHeights[var1][var2][var3], var6 + 1) && this.method2153(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3], var6 + 1) && this.method2153(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1], var6 + 128 - 1) && this.method2153(var5 + 1, this.tileHeights[var1][var2][var3 + 1], var6 + 128 - 1)) {
                this.field1558[var1][var2][var3] = Scene_drawnCount;
                return true;
            } else {
                this.field1558[var1][var2][var3] = -Scene_drawnCount;
                return false;
            }
        }
    }

    boolean method2087(int var1, int var2, int var3, int var4) {
        if (!this.method2086(var1, var2, var3)) {
            return false;
        } else {
            int var5 = var2 << 7;
            int var6 = var3 << 7;
            int var7 = this.tileHeights[var1][var2][var3] - 1;
            int var8 = var7 - 120;
            int var9 = var7 - 230;
            int var10 = var7 - 238;
            if (var4 < 16) {
                if (var4 == 1) {
                    if (var5 > Scene_cameraX) {
                        if (!this.method2153(var5, var7, var6)) {
                            return false;
                        }

                        if (!this.method2153(var5, var7, var6 + 128)) {
                            return false;
                        }
                    }

                    if (var1 > 0) {
                        if (!this.method2153(var5, var8, var6)) {
                            return false;
                        }

                        if (!this.method2153(var5, var8, var6 + 128)) {
                            return false;
                        }
                    }

                    if (!this.method2153(var5, var9, var6)) {
                        return false;
                    }

                    return this.method2153(var5, var9, var6 + 128);
                }

                if (var4 == 2) {
                    if (var6 < Scene_cameraZ) {
                        if (!this.method2153(var5, var7, var6 + 128)) {
                            return false;
                        }

                        if (!this.method2153(var5 + 128, var7, var6 + 128)) {
                            return false;
                        }
                    }

                    if (var1 > 0) {
                        if (!this.method2153(var5, var8, var6 + 128)) {
                            return false;
                        }

                        if (!this.method2153(var5 + 128, var8, var6 + 128)) {
                            return false;
                        }
                    }

                    if (!this.method2153(var5, var9, var6 + 128)) {
                        return false;
                    }

                    return this.method2153(var5 + 128, var9, var6 + 128);
                }

                if (var4 == 4) {
                    if (var5 < Scene_cameraX) {
                        if (!this.method2153(var5 + 128, var7, var6)) {
                            return false;
                        }

                        if (!this.method2153(var5 + 128, var7, var6 + 128)) {
                            return false;
                        }
                    }

                    if (var1 > 0) {
                        if (!this.method2153(var5 + 128, var8, var6)) {
                            return false;
                        }

                        if (!this.method2153(var5 + 128, var8, var6 + 128)) {
                            return false;
                        }
                    }

                    if (!this.method2153(var5 + 128, var9, var6)) {
                        return false;
                    }

                    return this.method2153(var5 + 128, var9, var6 + 128);
                }

                if (var4 == 8) {
                    if (var6 > Scene_cameraZ) {
                        if (!this.method2153(var5, var7, var6)) {
                            return false;
                        }

                        if (!this.method2153(var5 + 128, var7, var6)) {
                            return false;
                        }
                    }

                    if (var1 > 0) {
                        if (!this.method2153(var5, var8, var6)) {
                            return false;
                        }

                        if (!this.method2153(var5 + 128, var8, var6)) {
                            return false;
                        }
                    }

                    if (!this.method2153(var5, var9, var6)) {
                        return false;
                    }

                    return this.method2153(var5 + 128, var9, var6);
                }
            }

            if (!this.method2153(var5 + 64, var10, var6 + 64)) {
                return false;
            } else if (var4 == 16) {
                return this.method2153(var5, var9, var6 + 128);
            } else if (var4 == 32) {
                return this.method2153(var5 + 128, var9, var6 + 128);
            } else if (var4 == 64) {
                return this.method2153(var5 + 128, var9, var6);
            } else if (var4 == 128) {
                return this.method2153(var5, var9, var6);
            } else {
                return true;
            }
        }
    }

    boolean method2088(int var1, int var2, int var3, int var4) {
        if (!this.method2086(var1, var2, var3)) {
            return false;
        } else {
            int var5 = var2 << 7;
            int var6 = var3 << 7;
            return this.method2153(var5 + 1, this.tileHeights[var1][var2][var3] - var4, var6 + 1) && this.method2153(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3] - var4, var6 + 1) && this.method2153(var5 + 128 - 1, this.tileHeights[var1][var2 + 1][var3 + 1] - var4, var6 + 128 - 1) && this.method2153(var5 + 1, this.tileHeights[var1][var2][var3 + 1] - var4, var6 + 128 - 1);
        }
    }

    boolean method2089(int var1, int var2, int var3, int var4, int var5, int var6) {
        int var7;
        int var8;
        if (var3 == var2 && var5 == var4) {
            if (!this.method2086(var1, var2, var4)) {
                return false;
            } else {
                var7 = var2 << 7;
                var8 = var4 << 7;
                return this.method2153(var7 + 1, this.tileHeights[var1][var2][var4] - var6, var8 + 1) && this.method2153(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4] - var6, var8 + 1) && this.method2153(var7 + 128 - 1, this.tileHeights[var1][var2 + 1][var4 + 1] - var6, var8 + 128 - 1) && this.method2153(var7 + 1, this.tileHeights[var1][var2][var4 + 1] - var6, var8 + 128 - 1);
            }
        } else {
            for (var7 = var2; var7 <= var3; ++var7) {
                for (var8 = var4; var8 <= var5; ++var8) {
                    if (this.field1558[var1][var7][var8] == -Scene_drawnCount) {
                        return false;
                    }
                }
            }

            var7 = (var2 << 7) + 1;
            var8 = (var4 << 7) + 2;
            int var9 = this.tileHeights[var1][var2][var4] - var6;
            if (!this.method2153(var7, var9, var8)) {
                return false;
            } else {
                int var10 = (var3 << 7) - 1;
                if (!this.method2153(var10, var9, var8)) {
                    return false;
                } else {
                    int var11 = (var5 << 7) - 1;
                    if (!this.method2153(var7, var9, var11)) {
                        return false;
                    } else return this.method2153(var10, var9, var11);
                }
            }
        }
    }

    boolean method2153(int var1, int var2, int var3) {
        for (int var4 = 0; var4 < Scene_currentOccludersCount; ++var4) {
            Occluder var5 = Scene_currentOccluders[var4];
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            if (var5.field1852 == 1) {
                var6 = var5.minX - var1;
                if (var6 > 0) {
                    var7 = (var6 * var5.field1855 >> 8) + var5.minZ;
                    var8 = (var6 * var5.field1856 >> 8) + var5.maxZ;
                    var9 = (var6 * var5.field1857 >> 8) + var5.minY;
                    var10 = (var6 * var5.field1861 >> 8) + var5.maxY;
                    if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.field1852 == 2) {
                var6 = var1 - var5.minX;
                if (var6 > 0) {
                    var7 = (var6 * var5.field1855 >> 8) + var5.minZ;
                    var8 = (var6 * var5.field1856 >> 8) + var5.maxZ;
                    var9 = (var6 * var5.field1857 >> 8) + var5.minY;
                    var10 = (var6 * var5.field1861 >> 8) + var5.maxY;
                    if (var3 >= var7 && var3 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.field1852 == 3) {
                var6 = var5.minZ - var3;
                if (var6 > 0) {
                    var7 = (var6 * var5.field1842 >> 8) + var5.minX;
                    var8 = (var6 * var5.field1854 >> 8) + var5.maxX;
                    var9 = (var6 * var5.field1857 >> 8) + var5.minY;
                    var10 = (var6 * var5.field1861 >> 8) + var5.maxY;
                    if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.field1852 == 4) {
                var6 = var3 - var5.minZ;
                if (var6 > 0) {
                    var7 = (var6 * var5.field1842 >> 8) + var5.minX;
                    var8 = (var6 * var5.field1854 >> 8) + var5.maxX;
                    var9 = (var6 * var5.field1857 >> 8) + var5.minY;
                    var10 = (var6 * var5.field1861 >> 8) + var5.maxY;
                    if (var1 >= var7 && var1 <= var8 && var2 >= var9 && var2 <= var10) {
                        return true;
                    }
                }
            } else if (var5.field1852 == 5) {
                var6 = var2 - var5.minY;
                if (var6 > 0) {
                    var7 = (var6 * var5.field1842 >> 8) + var5.minX;
                    var8 = (var6 * var5.field1854 >> 8) + var5.maxX;
                    var9 = (var6 * var5.field1855 >> 8) + var5.minZ;
                    var10 = (var6 * var5.field1856 >> 8) + var5.maxZ;
                    if (var1 >= var7 && var1 <= var8 && var3 >= var9 && var3 <= var10) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void method2045(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        Occluder var8 = new Occluder();
        var8.minTileX = var2 / 128;
        var8.maxTileX = var3 / 128;
        var8.minTileY = var4 / 128;
        var8.maxTileY = var5 / 128;
        var8.type = var1;
        var8.minX = var2;
        var8.maxX = var3;
        var8.minZ = var4;
        var8.maxZ = var5;
        var8.minY = var6;
        var8.maxY = var7;
        Scene_planeOccluders[var0][Scene_planeOccluderCounts[var0]++] = var8;
    }

    public static void method2076(int[] var0, int var1, int var2, int var3, int var4) {
        Scene_viewportXMin = 0;
        Scene_viewportYMin = 0;
        Scene_viewportXMax = var3;
        Scene_viewportYMax = var4;
        Scene_viewportXCenter = var3 / 2;
        Scene_viewportYCenter = var4 / 2;
        boolean[][][][] var5 = new boolean[9][32][53][53];

        int var6;
        int var7;
        int var8;
        int var9;
        int var11;
        int var12;
        for (var6 = 128; var6 <= 384; var6 += 32) {
            for (var7 = 0; var7 < 2048; var7 += 64) {
                Scene_cameraPitchSine = Rasterizer3D.Rasterizer3D_sine[var6];
                Scene_cameraPitchCosine = Rasterizer3D.Rasterizer3D_cosine[var6];
                Scene_cameraYawSine = Rasterizer3D.Rasterizer3D_sine[var7];
                Scene_cameraYawCosine = Rasterizer3D.Rasterizer3D_cosine[var7];
                var8 = (var6 - 128) / 32;
                var9 = var7 / 64;

                for (int var10 = -26; var10 <= 26; ++var10) {
                    for (var11 = -26; var11 <= 26; ++var11) {
                        var12 = var10 * 128;
                        int var13 = var11 * 128;
                        boolean var14 = false;

                        for (int var15 = -var1; var15 <= var2; var15 += 128) {
                            if (method2112(var12, var0[var8] + var15, var13)) {
                                var14 = true;
                                break;
                            }
                        }

                        var5[var8][var9][var10 + 1 + 25][var11 + 1 + 25] = var14;
                    }
                }
            }
        }

        for (var6 = 0; var6 < 8; ++var6) {
            for (var7 = 0; var7 < 32; ++var7) {
                for (var8 = -25; var8 < 25; ++var8) {
                    for (var9 = -25; var9 < 25; ++var9) {
                        boolean var16 = false;

                        label82:
                        for (var11 = -1; var11 <= 1; ++var11) {
                            for (var12 = -1; var12 <= 1; ++var12) {
                                if (var5[var6][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label82;
                                }

                                if (var5[var6][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label82;
                                }

                                if (var5[var6 + 1][var7][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label82;
                                }

                                if (var5[var6 + 1][(var7 + 1) % 31][var8 + var11 + 1 + 25][var9 + var12 + 1 + 25]) {
                                    var16 = true;
                                    break label82;
                                }
                            }
                        }

                        field1569[var6][var7][var8 + 25][var9 + 25] = var16;
                    }
                }
            }
        }

    }

    static boolean method2112(int var0, int var1, int var2) {
        int var3 = var0 * Scene_cameraYawCosine + var2 * Scene_cameraYawSine >> 16;
        int var4 = var2 * Scene_cameraYawCosine - var0 * Scene_cameraYawSine >> 16;
        int var5 = var4 * Scene_cameraPitchCosine + Scene_cameraPitchSine * var1 >> 16;
        int var6 = Scene_cameraPitchCosine * var1 - var4 * Scene_cameraPitchSine >> 16;
        if (var5 >= 50 && var5 <= 3500) {
            int var7 = (var3 << 9) / var5 + Scene_viewportXCenter;
            int var8 = (var6 << 9) / var5 + Scene_viewportYCenter;
            return var7 >= Scene_viewportXMin && var7 <= Scene_viewportXMax && var8 >= Scene_viewportYMin && var8 <= Scene_viewportYMax;
        } else {
            return false;
        }
    }

    static final int method2113(int var0, int var1) {
        var1 = (var0 & 127) * var1 >> 7;
        if (var1 < 2) {
            var1 = 2;
        } else if (var1 > 126) {
            var1 = 126;
        }

        return (var0 & 'ﾀ') + var1;
    }
}
