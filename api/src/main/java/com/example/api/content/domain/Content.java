package com.example.api.content.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "TB_BA_CONTENT")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Content {

    @Id
    @Column(name = "CONT_ID", nullable = false)
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    Long contId;

    @Column(name = "CONT_NM")
    String contNm;

    @Column(name = "CONT_TYPE")
    String contType;

    @Column(name = "CONT_ORI_TXT")
    String contOriTxt;

    @Column(name = "CONT_FILE_PATH")
    String contFilePath;

    @Column(name = "CONT_FILE_NAME")
    String contFileName;

    @Column(name = "CONT_FILE_EXT")
    String contFileExt;

    @Column(name = "CREATOR")
    String creator;

    @CreatedDate
    @Column(name = "CREATETIME")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    Date createTime;

    @Column(name = "CONV_YN")
    String convYn;

    @Column(name = "USE_YN")
    String useYn;

    @Column(name = "DEL_YN")
    String delYn;

    @OneToMany(mappedBy = "content", fetch = FetchType.LAZY)
    private List<ContentKeyword> contentKeyword = new ArrayList<>();

    public void addKeyword(String keyword) {
        Keyword k = new Keyword(keyword);
        ContentKeyword ck = new ContentKeyword();
        ck.setKeyword(k);
        ck.setContent(this);
        this.contentKeyword.add(ck);
    }
}
