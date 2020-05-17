import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApkScanWin apkScanWin = new ApkScanWin();
        Map<String, String> markNameMap = new HashMap<String, String>();
        markNameMap.put("libchaosvmp.so", "Naga");
        markNameMap.put("libddog.so", "Naga");
        markNameMap.put("libfdog.so", "Naga");
        markNameMap.put("libedog.so", "Naga Enterprise");
        markNameMap.put("libexec.so", "IEncryption");
        markNameMap.put("libexecmain.so", "IEncryption");
        markNameMap.put("ijiami.dat", "IEncryption");
        markNameMap.put("ijiami.ajm", "IEncryption Enterprise");
        markNameMap.put("libsecexe.so", "Bangcle");
        markNameMap.put("libsecmain.so", "Bangcle");
        markNameMap.put("libSecShell.so", "Bangcle");
        markNameMap.put("libDexHelper.so", "Bangcle Enterprise");
        markNameMap.put("libDexHelper-x86.so", "Bangcle Enterprise");
        markNameMap.put("libprotectClass.so", "360");
        markNameMap.put("libjiagu.so", "360");
        markNameMap.put("libjiagu_art.so", "360");
        markNameMap.put("libjiagu_x86.so", "360");
        markNameMap.put("libegis.so", "Tongfu Shield");
        markNameMap.put("libNSaferOnly.so", "Tongfu Shield");
        markNameMap.put("libnqshield.so", "NetQin");
        markNameMap.put("libbaiduprotect.so", "Baidu");
        markNameMap.put("aliprotect.dat", "Alibaba Security");
        markNameMap.put("libsgmain.so", "Alibaba Security");
        markNameMap.put("libsgsecuritybody.so", "Alibaba Security");
        markNameMap.put("libmobisec.so", "Alibaba Security");
        markNameMap.put("libtup.so", "Tencent");
        markNameMap.put("libexec.so", "Tencent");
        markNameMap.put("libshell.so", "Tencent");
        markNameMap.put("mix.dex", "Tencent");
        markNameMap.put("lib/armeabi/mix.dex", "Tencent");
        markNameMap.put("lib/armeabi/mixz.dex", "Tencent");
        markNameMap.put("libtosprotection.armeabi.so", "Tencent Royal Security");
        markNameMap.put("libtosprotection.armeabi-v7a.so", "Tencent Royal Security");
        markNameMap.put("libtosprotection.x86.so", "Tencent Royal Security");
        markNameMap.put("libnesec.so", "Wangyi Shield");
        markNameMap.put("libAPKProtect.so", "APKProtect");
        markNameMap.put("libkwscmm.so", "Kiwi");
        markNameMap.put("libkwscr.so", "Kiwi");
        markNameMap.put("libkwslinker.so", "Kiwi");
        markNameMap.put("libx3g.so", "TopImage Security");
        markNameMap.put("libapssec.so", "Shengda");
        markNameMap.put("librsprotect.so", "RuiStar");
        apkScanWin.setMarkNameMap(markNameMap);
        apkScanWin.init();
    }
}
