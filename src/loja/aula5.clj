(ns loja.aula5
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(defn gastou-bastante? [info-do-usuario]
  (> (:preco-total info-do-usuario) 500))

(let [pedidos  (l.db/todos-os-pedidos)
      resumo   (l.logic/resumo-por-usuario pedidos)]
      (println "keep" (keep gastou-bastante? resumo))
      (println "filter" (filter gastou-bastante? resumo)))

(println "\n Tentando entender keep")

(defn gastou-bastante? [info-do-usuario]
  (println "gastou bastante" (:usuarios-id info-do-usuario))
  (> (:preco-total info-do-usuario) 500))

(let [pedidos  (l.db/todos-os-pedidos)
      resumo   (l.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastante? resumo)))

(println "\n Vamos isolaer")

(println (range 10))
(println (take 2(range 10000)))
;a sequência não esta sendo "gulosa" (eager)

(let [sequencia (range 1000000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia)))
; Função LAZY ( preguiçoso )


(defn filtro1 [x]
  (println "filtro 1" x)
  x)

(println (map filtro1 (range 10)))


(defn filtro2 [x]
  (println "filtro 2" x)
  x)

(println (map filtro2 (map filtro1 (range 10))))

(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)

; Chunks de 32 em 32
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)