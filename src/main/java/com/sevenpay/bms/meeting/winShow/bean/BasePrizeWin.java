package com.sevenpay.bms.meeting.winShow.bean;

import java.math.BigDecimal;
import java.util.Date;

public class BasePrizeWin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.win_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private Integer winId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.prize_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private Integer prizeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.win_cust_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String winCustId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.win_cust_name
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String winCustName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.win_cust_phone
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String winCustPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.win_amount
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private BigDecimal winAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.win_mark
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String winMark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.effective_deadline
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private Date effectiveDeadline;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.status
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.inst_user
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String instUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.inst_date
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String instDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.inst_datetime
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private Date instDatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.lupd_user
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private String lupdUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_prize_win.lupd_datetime
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    private Date lupdDatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.win_id
     *
     * @return the value of base_prize_win.win_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public Integer getWinId() {
        return winId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.win_id
     *
     * @param winId the value for base_prize_win.win_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setWinId(Integer winId) {
        this.winId = winId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.prize_id
     *
     * @return the value of base_prize_win.prize_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public Integer getPrizeId() {
        return prizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.prize_id
     *
     * @param prizeId the value for base_prize_win.prize_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setPrizeId(Integer prizeId) {
        this.prizeId = prizeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.win_cust_id
     *
     * @return the value of base_prize_win.win_cust_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getWinCustId() {
        return winCustId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.win_cust_id
     *
     * @param winCustId the value for base_prize_win.win_cust_id
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setWinCustId(String winCustId) {
        this.winCustId = winCustId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.win_cust_name
     *
     * @return the value of base_prize_win.win_cust_name
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getWinCustName() {
        return winCustName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.win_cust_name
     *
     * @param winCustName the value for base_prize_win.win_cust_name
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setWinCustName(String winCustName) {
        this.winCustName = winCustName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.win_cust_phone
     *
     * @return the value of base_prize_win.win_cust_phone
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getWinCustPhone() {
        return winCustPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.win_cust_phone
     *
     * @param winCustPhone the value for base_prize_win.win_cust_phone
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setWinCustPhone(String winCustPhone) {
        this.winCustPhone = winCustPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.win_amount
     *
     * @return the value of base_prize_win.win_amount
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public BigDecimal getWinAmount() {
        return winAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.win_amount
     *
     * @param winAmount the value for base_prize_win.win_amount
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setWinAmount(BigDecimal winAmount) {
        this.winAmount = winAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.win_mark
     *
     * @return the value of base_prize_win.win_mark
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getWinMark() {
        return winMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.win_mark
     *
     * @param winMark the value for base_prize_win.win_mark
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setWinMark(String winMark) {
        this.winMark = winMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.effective_deadline
     *
     * @return the value of base_prize_win.effective_deadline
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public Date getEffectiveDeadline() {
        return effectiveDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.effective_deadline
     *
     * @param effectiveDeadline the value for base_prize_win.effective_deadline
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setEffectiveDeadline(Date effectiveDeadline) {
        this.effectiveDeadline = effectiveDeadline;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.status
     *
     * @return the value of base_prize_win.status
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.status
     *
     * @param status the value for base_prize_win.status
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.inst_user
     *
     * @return the value of base_prize_win.inst_user
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getInstUser() {
        return instUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.inst_user
     *
     * @param instUser the value for base_prize_win.inst_user
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setInstUser(String instUser) {
        this.instUser = instUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.inst_date
     *
     * @return the value of base_prize_win.inst_date
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getInstDate() {
        return instDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.inst_date
     *
     * @param instDate the value for base_prize_win.inst_date
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setInstDate(String instDate) {
        this.instDate = instDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.inst_datetime
     *
     * @return the value of base_prize_win.inst_datetime
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public Date getInstDatetime() {
        return instDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.inst_datetime
     *
     * @param instDatetime the value for base_prize_win.inst_datetime
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setInstDatetime(Date instDatetime) {
        this.instDatetime = instDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.lupd_user
     *
     * @return the value of base_prize_win.lupd_user
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public String getLupdUser() {
        return lupdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.lupd_user
     *
     * @param lupdUser the value for base_prize_win.lupd_user
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setLupdUser(String lupdUser) {
        this.lupdUser = lupdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_prize_win.lupd_datetime
     *
     * @return the value of base_prize_win.lupd_datetime
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public Date getLupdDatetime() {
        return lupdDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_prize_win.lupd_datetime
     *
     * @param lupdDatetime the value for base_prize_win.lupd_datetime
     *
     * @mbggenerated Tue Jan 05 20:41:52 CST 2016
     */
    public void setLupdDatetime(Date lupdDatetime) {
        this.lupdDatetime = lupdDatetime;
    }
}