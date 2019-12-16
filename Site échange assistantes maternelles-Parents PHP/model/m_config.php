<?php

session_start();
try
{
    // On se connecte à MySQL
    $bdd = new PDO('mysql:host=xxx.db.1and1.com;dbname=xxx','xxx','xxx'); // on se connecte a  la base de donnnees
    $bdd->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
}
catch(Exception $e)
{
    // En cas d'erreur, on affiche un message et on arrête tout
    die('Erreur : '.$e->getMessage());
}
?>
