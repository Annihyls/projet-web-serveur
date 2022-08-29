<#ftl encoding="utf-8">
<body xmlns="http://www.w3.org/1999/html">
    <ul>
        <#list gommettes as gommette>
            <li>${gommette.id} -${gommette.description} ${gommette.couleur}</li>
        </#list>
    </ul>
    <form action="/gommettes/update" method="post">
        Modifier une gommette :
        <input id="id" name="id" placeholder="id ici" autocomplete="off">
        <input id="descriptionUpdate" name="descriptionUpdate" placeholder="description ici" autocomplete="off">
        <input id="couleurUpdate" name="couleurUpdate" placeholder="couleur ici" autocomplete="off">
        <input type="submit">
    </form>
    <form action="/gommettes/add" method="post">
        Creer une gommette :
        <input id="description" name="description" placeholder="description ici" autocomplete="off">
        <input id="couleur" name="couleur" placeholder="couleur ici" autocomplete="off">
        <input type="submit">
    </form>
    <br>
    <a href="/index">Retourner à la page d'accueil<a/>
</body>