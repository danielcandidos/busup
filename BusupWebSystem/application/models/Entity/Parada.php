<?php

namespace models\Entity;

/**
 * @Entity
 * @InheritanceType("SINGLE_TABLE")
 * @DiscriminatorColumn(name="tipo", type="string")
 * @DiscriminatorMap({"parada" = "Parada", "terminal" = "Terminal"})
 * @Table(name="Parada") 
 */
class Parada extends Entidade {

    /**
     * @Column(type="float")
     */
    protected $latitude;

    /**
     * @Column(type="float")
     */
    protected $longitude;

    /**
     * @Column(type="string")
     */
    protected $numero;

    /**
     * @Column(type="string", nullable=true)
     */
    protected $rua;

    /**
     * @Column(type="string",nullable=true)
     */
    protected $bairro;

    /**
     * @Column(type="string", nullable=true)
     */
    protected $descricao;

    public function getLatitude() {
        return $this->latitude;
    }

    public function getLongitude() {
        return $this->longitude;
    }

    public function getNumero() {
        return $this->numero;
    }

    public function getRua() {
        return $this->rua;
    }

    public function getBairro() {
        return $this->bairro;
    }

    public function getDescricao() {
        return $this->descricao;
    }

    public function setLatitude($latitude) {
        $this->latitude = $latitude;
    }

    public function setLongitude($longitude) {
        $this->longitude = $longitude;
    }

    public function setNumero($numero) {
        $this->numero = $numero;
    }

    public function setRua($rua) {
        $this->rua = $rua;
    }

    public function setBairro($bairro) {
        $this->bairro = $bairro;
    }

    public function setDescricao($descricao) {
        $this->descricao = $descricao;
    }

}
