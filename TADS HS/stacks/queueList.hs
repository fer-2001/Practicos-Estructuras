module QueueList where
import QueueADT

instance Queue [] where 
    empty = []
    enQueue xs x = [x] ++ xs 
    deQueue [x] = []
    deQueue (x:xs) = x : deQueue xs
    isEmpty xs = (length xs == 0)
    front [] = error "front: empty queue"
    front xs = last xs