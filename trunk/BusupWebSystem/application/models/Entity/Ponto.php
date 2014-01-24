<?php

namespace models\Entity;

/**
 * @Entity 
 * @InheritanceType("JOINED")
 **/
class Ponto extends Entidade{
    /*
     * @Column(type="float")
     */
    protected $latitude;
    /*
     * @Column(type="float")
     */
    protected $longitude;
    
    public function getLatitude() {
        return $this->latitude;
    }

    public function getLongitude() {
        return $this->longitude;
    }

    public function setLatitude($latitude) {
        $this->latitude = $latitude;
    }

    public function setLongitude($longitude) {
        $this->longitude = $longitude;
    }


}

