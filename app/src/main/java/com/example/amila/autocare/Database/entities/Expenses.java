package com.example.amila.autocare.Database.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by pavilion 15 on 14-Mar-18.
 */

@ForeignKey(entity = Vehicle.class,
        parentColumns = "reg_no", childColumns = "reg_no", onDelete = CASCADE)
@Entity(tableName = "expenses")
public class Expenses {

    @ColumnInfo(name = "reg_no")
    private String reg_no;
    @ColumnInfo(name = "expense_id")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int expense_id;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "expense")
    private float expense;
    /*@ColumnInfo(name = "year")
    private int year;
    @ColumnInfo(name = "month")
    private int month;*/
    @ColumnInfo(name = "date")
    private Date date;
    @ColumnInfo(name = "time")
    private String time;
    @ColumnInfo(name = "description")
    private String description;

    public Expenses(String reg_no, String category, float expense, Date date, String time, String description) {
        this.reg_no = reg_no;
        this.category = category;
        this.expense = expense;
        /*this.year = year;
        this.month = month;*/
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    @NonNull
    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(@NonNull int expense_id) {
        this.expense_id = expense_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    /*public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



