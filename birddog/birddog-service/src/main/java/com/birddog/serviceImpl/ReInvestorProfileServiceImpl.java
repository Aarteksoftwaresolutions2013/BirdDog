package com.birddog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.birddog.model.AccountSettings;
import com.birddog.model.Address;
import com.birddog.model.Login;
import com.birddog.model.ReInvestor;
import com.birddog.repository.AccountSettingsRepository;
import com.birddog.repository.AddressRepository;
import com.birddog.repository.LoginRepository;
import com.birddog.repository.ReInvestorRepository;
import com.birddog.service.ReInvestorProfileService;
import com.birddog.util.DateUtil;
import com.birddog.util.IConstant;

@Service
@Transactional
public class ReInvestorProfileServiceImpl implements ReInvestorProfileService {

    @Autowired
    private ReInvestorRepository reInvestorRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountSettingsRepository accountSettingsRepository;

    public void save(ReInvestor reInvestor) {
        if (reInvestor != null) {
            Address address = addressRepository.save(reInvestor.getAddress());
            reInvestor.setAddress(address);
            reInvestor.getEmail();
            reInvestorRepository.updateReInvester(reInvestor.getId(), reInvestor.getName(), reInvestor.getContactNo(),
                            reInvestor.getAddress().getId());

        }

    }

    public List<ReInvestor> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    public ReInvestor update(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    public ReInvestor getReiById(Integer id) {
        ReInvestor investor = reInvestorRepository.findById(id);
        return investor;

    }

    public void saveAddress(Address address) {
        addressRepository.save(address);

    }

    public void saveImages(String imageName, Integer id) {
        reInvestorRepository.updateByReInvestorId(id, imageName);

    }

    public boolean changeReInvestorPassword(String oldPassword, String newPassword, Integer id) {
        ReInvestor reInvestor = reInvestorRepository.findOne(id);
        Login login = loginRepository.findByEmail(reInvestor.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        boolean match = encoder.matches(oldPassword, login.getEncrypted());
        if (match) {
            login.setPassword(newPassword);
            login.setEncrypted(encoder.encode(newPassword));
            loginRepository.save(login);
            return true;
        } else {

            return false;
        }
    }

    public AccountSettings getAccountSettings(Integer id) {

        return accountSettingsRepository.findByReInvestorId(id);
    }

    public void saveAccountSettings(AccountSettings accountSettings) {
        // TODO Auto-generated method stub
        accountSettings.setIsDeleted(IConstant.ZERO);
        accountSettings.setCreationTime(DateUtil.todayDate());
        accountSettings.setUpdationTime(DateUtil.todayDate());
        accountSettingsRepository.save(accountSettings);
    }
}
