package com.sample.dao

import com.sample.entity.User
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class UserDaoTests {
    @Autowired
    lateinit var userDao: UserDao

    @Rule
    @JvmField
    final val thrown = ExpectedException.none()

    @Test
    fun selectById_idExists_returnTargetUser() {
        val user = User(
                password = "dummy password",
                screenName = "screen name",
                displayName = "display name"
        )

        val insertResult = userDao.insert(user)
        val id = insertResult.entity.id
        assertThat(id, `is`(notNullValue()))

        val selectResult = userDao.selectById(insertResult.entity.id!!)
        assertEquals(insertResult.entity, selectResult)
    }

    @Test
    fun selectById_idNotExists_throwException() {
        thrown.expect(EmptyResultDataAccessException::class.java)
        userDao.selectById(-1)
    }
}