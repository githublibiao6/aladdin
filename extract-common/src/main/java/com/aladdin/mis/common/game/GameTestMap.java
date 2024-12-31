package com.aladdin.mis.common.game;

/**
 * 游戏地图
 */
public class GameTestMap {

    public static void main(String[] args) {
        // 生成地图
//        getMap();
        //
        getGas();
    }

    private static void getGas(){
        FastNoiseLite noise = new FastNoiseLite(100);
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        noise.SetFractalType(FastNoiseLite.FractalType.Ridged);
        noise.SetFractalOctaves(10);
        int size = 100;
        // Gather noise data
        float[][] noiseData = new float[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                noiseData[x][y] = noise.GetNoise(x, y);
            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                float n = noiseData[i][j];
                System.err.print(noiseData[i][j] + ",");
                s.append(getTileMap(n)).append(",");
            }
            System.err.println("");
        }
        System.err.println(s.toString());
    }

    private static void getMap(){
        FastNoiseLite noise = new FastNoiseLite(100);
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        noise.SetFractalType(FastNoiseLite.FractalType.FBm);
        noise.SetFractalOctaves(10);
        int size = 100;
        // Gather noise data
        float[][] noiseData = new float[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                noiseData[x][y] = noise.GetNoise(x, y);
            }
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                float n = noiseData[i][j];
                System.err.print(noiseData[i][j] + ",");
                s.append(getTileMap(n)).append(",");
            }
            System.err.println("");
        }
        System.err.println(s.toString());
    }

    private static int getTileMap(float n){
        if(n < 0){
            n = -n;
        }
        if(n <= 0.15){
            return 4;
        }else if(n <= 0.92){
            if(0.6<n && n <0.61){
                return 2;
            }
            if(0.7<n && n <0.71){
                return 2;
            }
            if(0.8<n && n <0.81){
                return 2;
            }
            return 1;
        }else  {
            return 3;
        }
    }
}
