package com.birddog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.birddog.model.AccountSettings;

public interface AccountSettingsRepository extends JpaRepository<AccountSettings, Integer> {

    AccountSettings findByReInvestorId(Integer id);

}
