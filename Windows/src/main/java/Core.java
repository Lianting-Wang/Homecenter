import com.sun.jna.Native;
import com.sun.jna.platform.win32.Shell32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.win32.StdCallLibrary;

import java.awt.*;

public class Core {
    private interface User32 extends StdCallLibrary {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);

        void MessageBoxA(WinDef.HWND hwnd, String s, String s1, int i);
        WinDef.HWND FindWindowA(String s1, String s2);
        void PostMessageA(WinDef.HWND hwnd, int wmClose, Object o, Object o1);
    }

    public static void closeWindows(String s1, String s2) {
        WinDef.HWND hwnd = User32.INSTANCE.FindWindowA(s1, s2);
        User32.INSTANCE.PostMessageA(hwnd, WinUser.WM_CLOSE, null, null);
    }

    public static void showMessageBox(String s1, String s2) {
        System.setProperty("jna.encoding","GBK");
        User32.INSTANCE.MessageBoxA(null, s1, s2, 0);
    }

    public static void shortcutKeys(int key1, int key2) throws AWTException {
        Robot r = new Robot();
        r.keyPress(key1);
        r.keyPress(key2);
        r.keyRelease(key1);
        r.keyRelease(key2);
    }

    public static void shortcutKeys(int key1, int key2, int key3) throws AWTException {
        Robot r = new Robot();
        r.keyPress(key1);
        r.keyPress(key2);
        r.keyPress(key3);
        r.keyRelease(key1);
        r.keyRelease(key2);
        r.keyRelease(key3);
    }

    public static void shellExecute(String s, String s1, String s3) {
        final int SW_SHOWNORMAL = 1;
        Shell32.INSTANCE.ShellExecute(null, s, s1, null, s3, SW_SHOWNORMAL);
    }
}
