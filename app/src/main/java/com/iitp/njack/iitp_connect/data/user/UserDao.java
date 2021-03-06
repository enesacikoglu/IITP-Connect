package com.iitp.njack.iitp_connect.data.user;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM " + User.TABLE_NAME)
    LiveData<List<User>> getUsers();

    @Query("SELECT * FROM " + User.TABLE_NAME + " WHERE id=:id")
    LiveData<User> getUserById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);
}
