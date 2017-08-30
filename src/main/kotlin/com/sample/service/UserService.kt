package com.sample.service

import com.sample.dao.UserDao
import com.sample.entity.User
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userDao: UserDao
) {
    fun getUser(id: Long): User {
        return userDao.selectById(id)
    }
}