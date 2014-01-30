<?php

namespace models\Entity;

/**
 * @Entity
 */
class Itinerario extends Entidade {

    /**
     * @Column(type="string")
     */
    protected $nome;

    /**
     * @Column(type="float")
     */
    protected $tamanho;

    /**
     * @ManyToOne(targetEntity="Linha", inversedBy="itinerario")
     * @JoinColumn(name="linha_id", referencedColumnName="id")
     * */
    protected $linha;

    /**
     * @OneToMany(targetEntity="Percurso",mappedBy="itinerario"   )
     */
    Protected $percursos;

    public function __construct() {
        $this->percurso = new ArrayCollection();
    }
    
    public function getNome() {
        return $this->nome;
    }

    public function getTamanho() {
        return $this->tamanho;
    }

    public function getLinha() {
        return $this->linha;
    }

    public function getPercursos() {
        return $this->percursos;
    }

    public function setNome($nome) {
        $this->nome = $nome;
    }

    public function setTamanho($tamanho) {
        $this->tamanho = $tamanho;
    }

    public function setLinha($linha) {
        $this->linha = $linha;
    }

    public function setPercursos($percursos) {
        $this->percursos = $percursos;
    }



    



}
