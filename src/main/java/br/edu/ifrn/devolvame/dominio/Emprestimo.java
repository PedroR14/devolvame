/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrn.devolvame.dominio;

import java.util.Date;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nayarocha
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"idEmprestimo"})
@Builder
public class Emprestimo {
    private int idEmprestimo;
    private Usuario donoLivro;
    private Usuario destinatario;
    private Livro livro;
    private Date data;
    
}
