<#ftl encoding="utf-8">
<body xmlns="http://www.w3.org/1999/html">
    <ul>
        <#list eleves as eleve>
            <li>${eleve.id} -${eleve.nom} ${eleve.prenom} ${eleve.dateNaissance}</li>
        </#list>
    </ul>
    <form action="/eleves/update" method="post">
        Modifier un élève :
        <input id="id" name="id" placeholder="id ici" autocomplete="off">
        <input id="nomUpdate" name="nomUpdate" placeholder="nom ici" autocomplete="off">
        <input id="prenomUpdate" name="prenomUpdate" placeholder="prenom ici" autocomplete="off">
        <input id="dateNaissanceUpdate" name="dateNaissanceUpdate" placeholder="dd-mm-yyyy" autocomplete="off">
        <input type="submit">
    </form>
    <form action="/eleves/add" method="post">
        Ajouter un élève:
        <input id="nom" name="nom" placeholder="nom ici" autocomplete="off">
        <input id="prenom" name="prenom" placeholder="prenom ici" autocomplete="off">
        <input id="dateNaissance" name="dateNaissance" placeholder="dd-mm-yyyy" autocomplete="off">
        <input type="submit">
    </form>
    <form action="redirect/eleve/gommettes" method="get">
        L'id de l'élève pour accéder à ses gommettes: 
        <input id="eleveid" name="eleveid" placeholder="id de elevegommette ici" autocomplete="off">
        <input type="submit">
    </form>
    <br>
    <a href="/index">Retourner à la page d'accueil<a/>
</body>