<?php
namespace models\Entity;

/**
 * @Entity
 * @InheritanceType("SINGLE_TABLE")
 * @DiscriminatorColumn(name="discr", type="string")
 * @DiscriminatorMap({"person" = "Parada", "employee" = "Terminal"})
 * @Table(name="Parada") 
 */
class Parada extends Entidade{
    /**
     * @Column(type="float")
     */
    protected $latitude;
    /**
     * @Column(type="float")
     */
    protected $longitude;
    /**
     * @Column(type="integer")
     */
    protected $numero;
    /**
     * @Column(type="string")
     */
    protected $endereco;  


    public function getLatitude() {
        return $this->latitude;
    }

    public function getLongitude() {
        return $this->longitude;
    }

    public function getNumero() {
        return $this->numero;
    }

    public function getEndereco() {
        return $this->endereco;
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

    public function setEndereco($endereco) {
        $this->endereco = $endereco;
    }




}

