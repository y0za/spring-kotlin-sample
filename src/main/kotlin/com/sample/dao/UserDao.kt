package com.sample.dao

import com.sample.entity.User
import org.seasar.doma.Dao
import org.seasar.doma.Insert
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable
import org.seasar.doma.jdbc.Result

@ConfigAutowireable
@Dao
interface UserDao {
    @Select(ensureResult = true)
    fun selectById(id: Long): User

    @Insert
    fun insert(user: User): Result<User>
}