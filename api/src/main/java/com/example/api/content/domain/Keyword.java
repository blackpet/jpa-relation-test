package com.example.api.content.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TB_BA_KEYWORD")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Keyword {
    @Id
    @Column(name = "KEYW_ID", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long keywId;

    @Column(name = "KEYW_NM")
    String keywNm;

    @Column(name = "ALL_EXCEPT_YN")
    String allExceptYn;

    @Column(name = "CONV_YN")
    String convYn;

    @Column(name = "MAT_YN")
    String matYn;

    @Column(name = "USE_YN")
    String useYn;

    @Column(name = "DEL_YN")
    String delYn;

    @Column(name = "CREATOR")
    String creator;

    @CreatedDate
    @Column(name = "CREATETIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;


    public Keyword(String keyword) {
        this.keywNm = keyword;
    }
}
