<?php

namespace models\Entity;
/**
 * @Entity
 */
class Linha extends Entidade{
    /**
     * @Column(type="string")
     */
    protected $nome;    
    /**
     * @Column(type="string")
     */
    protected $numero;
    /**
     * @OnoToMany(targetEntity="Itinerario",mappedBy="linha"   )
     */
    Protected $itinerarios;
    
    public function __construct() {
        $this->itinerarios = new ArrayCollection();
    }
    
    public function getNome() {
        return $this->nome;
    }

    public function getNumero() {
        return $this->numero;
    }

    public function getItinerarios() {
        return $this->itinerarios;
    }

    public function setNome($nome) {
        $this->nome = $nome;
    }

    public function setNumero($numero) {
        $this->numero = $numero;
    }

    public function setItinerarios($itinerarios) {
        $this->itinerarios = $itinerarios;
    }


}

