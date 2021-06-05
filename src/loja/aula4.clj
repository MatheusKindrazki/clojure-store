(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

;(println (loja.db/todos-os-pedidos))

(let [pedidos  (l.db/todos-os-pedidos)
      resumo   (l.logic/resumo-por-usuario pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado ao contrário" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado ao contrário" (sort-by :usuarios-id resumo))
  (println (get-in pedidos [0 :itens :mochila :quantidade])))

; -----

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(let [pedidos  (l.db/todos-os-pedidos)
      resumo   (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Primeiro" (first resumo))
  (println "Segundo" (second resumo))
  (println "Resto" (rest resumo))
  (println "Total" (count resumo))
  (println "Class" (class resumo))
  (println "nth 1" (nth resumo 1))
  (println "get 1" (get resumo 1))
  (println "take" (take 2 resumo))
  )

(defn top-2 [resumo]
  (take 2 resumo))

(let [pedidos  (l.db/todos-os-pedidos)
      resumo   (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Top 2" (top-2 pedidos))
  )

;------

(let [pedidos  (l.db/todos-os-pedidos)
      resumo   (resumo-por-usuario-ordenado pedidos)]
  (println "Maior de 500 filter" (filter #(> (:preco-total %) 500) resumo))
  (println "Maior de 500 some" (some #(> (:preco-total %) 500) resumo)))
