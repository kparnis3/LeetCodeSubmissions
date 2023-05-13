class Solution {
    public double[] convertTemperature(double celsius) {
        
        double temps[] = new double[2];
        temps[0] = celsius + 273.15;
        temps[1] = celsius * 1.80 + 32.00;

        return temps;

    }
}