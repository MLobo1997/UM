SELECT Nome FROM Disciplinas
INNER JOIN Docentes AS d ON Disciplinas.Docentes_Codigo = d.Codigo
GROUP BY Docentes_Codigo
ORDER BY COUNT(d.Codigo) DESC
LIMIT 3;
