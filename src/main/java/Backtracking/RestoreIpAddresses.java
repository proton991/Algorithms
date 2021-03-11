package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 99615
 * @Date: 2021/1/29 11:19
 * @Description:
 */
public class RestoreIpAddresses {
    List<String> ans = new ArrayList<>();
    int n;
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12)
            return ans;
        n = s.length();
        StringBuffer buffer = new StringBuffer();
        List<String> list = new ArrayList<>();
        backtrack(s, 0, list);
        return ans;
    }

    void backtrack(String s, int start, List<String> list) {
        if (start == n && list.size() == 4) {
            ans.add(getStr(list));
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            String tmp = s.substring(start, i);
            if (isValidPart(tmp)) {
                list.add(tmp);
                backtrack(s, i, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private String getStr(List<String> list) {
        StringBuffer res = new StringBuffer();
        for (String str : list) {
            if (res.length() == 0) {
                res.append(str);
            } else {
                res.append(".");
                res.append(str);
            }
        }
        return res.toString();
    }

    public boolean isValidPart(String part) {
        if ( part.length() == 0 || part.length() > 3)
            return false;
        if (Integer.parseInt(part) > 255)
            return false;
        if (part.charAt(0) == '0' && part.length() > 1)
            return  false;
        return true;
    }
}
