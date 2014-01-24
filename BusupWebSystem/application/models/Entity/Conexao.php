<?php
namespace models\Entity;
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @Entity
 */
class Conexao extends Entidade{
    /**
     * @ManyToOne(targetEntity="Parada",inversedBy="conexao")
     */
    protected $origem;
    /**
     * @ManyToOne(targetEntity="Parada",inversedBy="conexao")
     */
    protected $destino;
    /**
     * @Column(type="float")
     */
    protected $distancia;
    
    public function getOrigem() {
        return $this->origem;
    }

    public function getDestino() {
        return $this->destino;
    }

    public function getDistancia() {
        return $this->distancia;
    }

    public function setOrigem($origem) {
        $this->origem = $origem;
    }

    public function setDestino($destino) {
        $this->destino = $destino;
    }

    public function setDistancia($distancia) {
        $this->distancia = $distancia;
    }


    
    
    
}


