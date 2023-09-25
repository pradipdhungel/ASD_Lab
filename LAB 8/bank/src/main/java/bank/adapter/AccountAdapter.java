package bank.adapter;
import bank.domain.Account;
import bank.domain.dto.AccountDTO;

import java.util.ArrayList;
import java.util.Collection;

public class AccountAdapter {
    public AccountDTO convertAccountToDTO(Account account){
        return new AccountDTO(account.getAccountnumber(),account.getEntryList(),account.getCustomer());

    }
    public Collection<AccountDTO> convertAccountListToDTO(Collection<Account> list){
        Collection<AccountDTO> accountDTOS=new ArrayList<>();
        for(Account account: list){
            accountDTOS.add(new AccountDTO(account.getAccountnumber(),account.getEntryList(),account.getCustomer()));
        }
        return accountDTOS;
    }
}
