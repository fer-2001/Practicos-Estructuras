-- Autor: Manuel Fernandez

module TadConjuntos where
-- Creacion de class para implementacion del TAD conjuntos.
class Conjuntos s where
    -- Devuelve la lista vacia
    vacia :: s a
    -- Inserta de forma ordenada un elemento a la lista
    ins :: (Ord a) => a -> s a -> s a
    -- Union de dos listas
    union :: (Ord a) => s a -> s a -> s a
    -- Determina si un elemento pertenece a la lista
    pertenece :: (Eq a) => a -> s a -> Bool