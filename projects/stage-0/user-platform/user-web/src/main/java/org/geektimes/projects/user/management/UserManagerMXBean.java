package org.geektimes.projects.user.management;

import org.geektimes.projects.user.domain.User;

/**
 * {@link User} MXBean 接口描述
 */
public interface UserManagerMXBean {

    // MBeanAttributeInfo 列表
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    // MBeanOperationInfo
    String toString();

    User getUser();

}