package account;

import java.util.ArrayList;
import java.util.List;

public class AccountManagement {
    private final List<Account> accountList = new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }

    public void RegisterAnAccount(Account account) {
        accountList.add(account);
    }

    public void deleteTheAccount(String userName) {
        if (accountSearch(userName) == -1) {
            System.out.println("Không tìm thấy tài khoản này vui lòng thử lại !");
        } else {
            accountList.remove(accountSearch(userName));
            System.out.println("Đã xóa tài khoản!");
        }
    }

    public int accountSearch(String userName) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }
    public void showAccounts(){
        for (Account account: accountList) {
            System.out.println(account);
        }
    }
}
