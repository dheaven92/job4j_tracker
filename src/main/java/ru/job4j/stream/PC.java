package ru.job4j.stream;

public class PC {

    private String cpuName;
    private int cpuCores;
    private String gpuName;
    private int gpuMemory;
    private int hardDriveMemory;
    private int solidDriveMemory;
    private boolean isWaterCooling;

    static class Builder {
        private String cpuName;
        private int cpuCores;
        private String gpuName;
        private int gpuMemory;
        private int solidDriveMemory;
        private int hardDriveMemory;

        private boolean isWaterCooling;

        Builder buildCpuName(String cpuName) {
            this.cpuName = cpuName;
            return this;
        }

        Builder buildCpuCores(int cpuCores) {
            this.cpuCores = cpuCores;
            return this;
        }

        Builder buildGpuName(String gpuName) {
            this.gpuName = gpuName;
            return this;
        }

        Builder buildGpuMemory(int gpuMemory) {
            this.gpuMemory = gpuMemory;
            return this;
        }

        Builder buildHardDriveMemory(int hardDriveMemory) {
            this.hardDriveMemory = hardDriveMemory;
            return this;
        }

        Builder buildSolidDriveMemory(int solidDriveMemory) {
            this.solidDriveMemory = solidDriveMemory;
            return this;
        }

        Builder buildIsWaterCooling(boolean isWaterCooling) {
            this.isWaterCooling = isWaterCooling;
            return this;
        }

        PC build() {
            PC pc = new PC();
            pc.cpuName = cpuName;
            pc.cpuCores = cpuCores;
            pc.gpuName = gpuName;
            pc.gpuMemory = gpuMemory;
            pc.hardDriveMemory = hardDriveMemory;
            pc.solidDriveMemory = solidDriveMemory;
            pc.isWaterCooling = isWaterCooling;
            return pc;
        }
    }

    @Override
    public String toString() {
        return "PC{"
                + "cpuName='" + cpuName + '\''
                + ", cpuCores=" + cpuCores
                + ", gpuName='" + gpuName + '\''
                + ", gpuMemory=" + gpuMemory
                + ", hardDriveMemory=" + hardDriveMemory
                + ", solidDriveMemory=" + solidDriveMemory
                + ", isWaterCooling=" + isWaterCooling
                + '}';
    }

    public static void main(String[] args) {
        PC myPc = new Builder()
                .buildCpuName("AMD Ryzen 7 2700")
                .buildCpuCores(8)
                .buildGpuName("RTX 3070 ti Gigabyte Aorus Master")
                .buildGpuMemory(8)
                .buildHardDriveMemory(2000)
                .buildSolidDriveMemory(2000)
                .buildIsWaterCooling(false)
                .build();
        System.out.println(myPc);
    }
}
