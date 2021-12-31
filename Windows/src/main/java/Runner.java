import java.util.Arrays;

public final class Runner {
    private static final String[] index = new String[]{"000", "001", "101", "102", "103"};
    private static final int[] method = new int[]{0, 0, 1, 1, 1};
    private static final String[] name = new String[]{"", "", "chrome.exe", "steam.exe", "BH3.exe"};
    private static final String[] locate = new String[]{"", "", "C:\\%programfiles%\\Google\\Chrome\\Application", "\"C:\\Program Files (x86)\\Steam\"", "D:\\SteamLibrary\\steamapps\\common\\HonkaiImpact3rd"};

    public static void run(String code) {
        int i = Arrays.binarySearch(index, code);
        if (method[i]==1) {
            open(name[i], locate[i]);
        }
    }

    private static void open(String name, String locate) {
        try {
            String[] cmd = {".\\opener.exe", name, locate};
            Process process = Runtime.getRuntime().exec(cmd);
            int status = process.waitFor();
            if(status != 0){
                System.err.println("Failed to call shell's command and the return status's is: " + status);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}