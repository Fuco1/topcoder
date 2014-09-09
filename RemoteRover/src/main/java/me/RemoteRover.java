package me;

public class RemoteRover {

    public RemoteRover() {}

    public static double optimalTime(int[] width, int[] speed, int offset) {
        int maxSpeed = 0;
        for (int i = 0; i < speed.length; i++) {
            if (maxSpeed < speed[i]) maxSpeed = speed[i];
        }
        double high = 1.0 / maxSpeed;
        double low = 0;
        double m;
        double s = 0;
        double[] parts = new double[width.length];
        for (int i = 0; i < 100; i++) {
            m = (low + high) / 2.0;
            s = 0;
            for (int j = 0; j < width.length; j++) {
                parts[j] = width[j] * m * speed[j] / Math.sqrt(1 - m*m*speed[j]*speed[j]);
                s += parts[j];
            }
            if (s >= offset) {
                high = m;
            } else {
                low = m;
            }
        }
        double time = 0;
        for (int i = 0; i < parts.length; i++) {
            time += Math.sqrt(parts[i]*parts[i] + width[i]*width[i]) / speed[i];
        }
        return time;
    }
}
