<?php

namespace models\Entity;

/**
 * @Entity
 */
class Percurso extends Entidade {

    /**
     * @Column(type="integer")
     */
    protected $index;

    /**
     * @OnetoOne(targetEntity="Conexao")
     * @JoinColumn(name="conexao_id", referencedColumnName="id")
     */
    protected $conexao;

    /**
     * @ManyToOne(targetEntity="Itinerario", inversedBy="percurso")
     * @JoinColumn(name="itinerario_id", referencedColumnName="id")
     * */
    protected $itinerario;
    
    public function getIndex() {
        return $this->index;
    }

    public function getConexao() {
        return $this->conexao;
    }

    public function getItinerario() {
        return $this->itinerario;
    }

    public function setIndex($index) {
        $this->index = $index;
    }

    public function setConexao($conexao) {
        $this->conexao = $conexao;
    }

    public function setItinerario($itinerario) {
        $this->itinerario = $itinerario;
    }



}
