class ParkingSystem {
    private int[] slots;
    
    public ParkingSystem(int big, int medium, int small) {
        //fill first with empty since not accessed 
        slots = new int[] {0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (slots[carType] == 0) {
            return false;
        }
        slots[carType]--;
        
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */