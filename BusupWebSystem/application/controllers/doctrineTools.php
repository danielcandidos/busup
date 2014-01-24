<?php

if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class DoctrineTools extends CI_Controller {  

    //Doctrine EntityManager
    public $em;

    function __construct() {
        parent::__construct();
        //Instantiate a Doctrine Entity Manager
        //$this->load->library('doctrine');
        $this->em = $this->doctrine->em;
    }

    function update() {
        echo 'Doctrine: Atualizar estrutura do banco de dados.<br /><br />
		<form action="" method="POST">
		Inserir Dados<input type="checkbox" name="dados" value="1"><br /><br />
		<input type="submit" name="action" value="Atualizar Banco"><br /><br />
                </form>';

        if ($this->input->post('action')) {
            try {
                $tool = new \Doctrine\ORM\Tools\SchemaTool($this->em);

                $classes = array(                    
                    $this->em->getClassMetadata('models\Entity\Parada'),
                    $this->em->getClassMetadata('models\Entity\Terminal'),
                    $this->em->getClassMetadata('models\Entity\Conexao')
                );
                
                $tool->dropSchema($classes);
                //$tool->createSchema($classes);
                $tool->updateSchema($classes);



                if (isset($_POST['dados'])) {
                    $this->InserirDadosIniciais();
                }

                echo "Pronto!";
            } catch (Exception $exception) {
                echo $exception->getMessage();
            }
        }
    }

    function InserirDadosIniciais() {
        
    }

}
