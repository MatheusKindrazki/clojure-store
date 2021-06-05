(ns loja.aula1)

;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]
;{"guilherme" 37, "paulo" 39}
;(1 2 3 4 5)
;[[0 1]]
;#{}

;(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest  ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (next  ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))

(println (seq [1 2 3 4]))

(println "\n\nMEU MAPA")
;
;(defn meu-mapa
;  [funcao sequencia]
;  (let [primeiro (first sequencia)]
;    (funcao primeiro)
;    (meu-mapa funcao (rest sequencia))))

;(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])

(println "\n\nMEU MAPA COM PARADA")

(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if primeiro
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))
    ))

(println "\n\nMEU MAPA COM PARADA NO NIL")
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (meu-mapa funcao (rest sequencia))))
    ))

(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])