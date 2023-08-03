package com.example.api.content.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
@Table(name = "TB_BA_CONT_KEYW_MAPP")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DynamicInsert
public class ContentKeyword  {
    @Id
    @Column(name = "CONT_KEYW_ID", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long contKeywId;

    @Column(name = "KEYW_RANK")
    int keywRank;

    @Column(name = "MAT_RATE")
    float matRate;

    @Column(name = "EXCEPT_YN")
    String exceptYn;

    @Column(name = "DEL_YN")
    String delYn;

    @Column(name = "CREATOR")
    String creator;

    @CreatedDate
    @Column(name = "CREATETIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    @ManyToOne(optional = false)
    @JsonIgnore
    @JoinColumn(name = "CONT_ID")
    private Content content;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "KEYW_ID")
    private Keyword keyword;




}
