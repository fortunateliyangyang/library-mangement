package com.book.librarymangement.entity;

import java.io.Serializable;

/**
 * student
 * @author 
 */
public class Student implements Serializable {
    private String id;

    private String name;

    private String password;

    private Integer year;

    private String classes;

    /**
     * 院系
     */
    private Byte faculty;

    private String sex;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像存储路径
     */
    private String headSulpture;

    private String personalityWord;

    private String birth;

    private String email;

    private String telephone;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Byte getFaculty() {
        return faculty;
    }

    public void setFaculty(Byte faculty) {
        this.faculty = faculty;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadSulpture() {
        return headSulpture;
    }

    public void setHeadSulpture(String headSulpture) {
        this.headSulpture = headSulpture;
    }

    public String getPersonalityWord() {
        return personalityWord;
    }

    public void setPersonalityWord(String personalityWord) {
        this.personalityWord = personalityWord;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getYear() == null ? other.getYear() == null : this.getYear().equals(other.getYear()))
            && (this.getClasses() == null ? other.getClasses() == null : this.getClasses().equals(other.getClasses()))
            && (this.getFaculty() == null ? other.getFaculty() == null : this.getFaculty().equals(other.getFaculty()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getHeadSulpture() == null ? other.getHeadSulpture() == null : this.getHeadSulpture().equals(other.getHeadSulpture()))
            && (this.getPersonalityWord() == null ? other.getPersonalityWord() == null : this.getPersonalityWord().equals(other.getPersonalityWord()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getYear() == null) ? 0 : getYear().hashCode());
        result = prime * result + ((getClasses() == null) ? 0 : getClasses().hashCode());
        result = prime * result + ((getFaculty() == null) ? 0 : getFaculty().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getHeadSulpture() == null) ? 0 : getHeadSulpture().hashCode());
        result = prime * result + ((getPersonalityWord() == null) ? 0 : getPersonalityWord().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", year=").append(year);
        sb.append(", classes=").append(classes);
        sb.append(", faculty=").append(faculty);
        sb.append(", sex=").append(sex);
        sb.append(", nickName=").append(nickName);
        sb.append(", headSulpture=").append(headSulpture);
        sb.append(", personalityWord=").append(personalityWord);
        sb.append(", birth=").append(birth);
        sb.append(", email=").append(email);
        sb.append(", telephone=").append(telephone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}