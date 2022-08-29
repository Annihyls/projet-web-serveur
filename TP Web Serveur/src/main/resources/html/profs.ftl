<#ftl encoding="utf-8">
<body xmlns="http://www.w3.org/1999/html">
    <ul>
        <#list profs as prof>
            <li>${prof.id} -${prof.nom} ${prof.prenom} ${prof.username}</li>
        </#list>
    </ul>
    <form action="/profs/update" method="post">
            Modifier un professeur :
            <input id="id" name="id" placeholder="id ici" autocomplete="off">
            <input id="nomUpdate" name="nomUpdate" placeholder="nom ici" autocomplete="off">
            <input id="prenomUpdate" name="prenomUpdate" placeholder="prenom ici" autocomplete="off">
            <input id="usernameUpdate" name="usernameUpdate" placeholder="username ici" autocomplete="off">
            <input type="submit">
        </form>
    <form action="/profs/add" method="post">
            Ajouter un professeur:
            <input id="nom" name="nom" placeholder="nom ici" autocomplete="off">
            <input id="prenom" name="prenom" placeholder="prenom ici" autocomplete="off">
            <input id="username" name="username" placeholder="username ici" autocomplete="off">
            <input type="submit">
        </form>
    <br>
    <a href="/index">Retourner à la page d'accueil<a/>
</body>