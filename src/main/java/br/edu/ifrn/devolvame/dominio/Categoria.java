package br.edu.ifrn.devolvame.dominio;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nayarocha
 */
@Getter
@Setter
@ToString(exclude = "livrosDaCategoria")
@EqualsAndHashCode(of = {"nomeCategoria"})
@Builder
@Entity
@SequenceGenerator(sequenceName = "seq_categoria", name = "ID_SEQUENCE", allocationSize = 1)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Categoria implements Comparable<Categoria>, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private Long id;
    
    @Column(nullable = false)
    private String nomeCategoria;
   
    
    
    @OneToMany(mappedBy =  "categoria")
    private Set<Livro> livrosDaCategoria; 


    @Override
    public int compareTo(Categoria o) {
        int result = 0;
		if (nomeCategoria != null && o.nomeCategoria != null) {
			result = this.nomeCategoria.compareTo(o.nomeCategoria);
		}
		else if (this.nomeCategoria == null && o.nomeCategoria == null) {
			result = 0;
		}
		else if (this.nomeCategoria == null) {
			result = -1;
		}
		else {
			result = +1;
		}
		return result;
    }    
}
