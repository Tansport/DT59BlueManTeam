/**
 * Project Name:study
 * File Name:QuestionInfo.java
 * Package Name:com.test.entity
 * Date:2018年3月28日下午4:12:17
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.test.entity;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:12:17 <br/>
 * 
 * @author liutao
 * @version
 * @see
 */
public class QuestionInfo {
    private int questionId;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private int subject;

    private String answer;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String string) {
        this.answer = string;
    }

}
