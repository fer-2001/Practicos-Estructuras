module QueueADT where

class Queue q where
    -- | empty Queue 
    empty :: q a 
    -- | add an element to the Queue 
    enQueue :: q a -> a -> q a
    -- | remove an element to the Queue 
    deQueue :: q a -> q a 
    -- | it says if the Queue is empty
    isEmpty :: q a -> Bool 
    -- | returns the first element to enter the queue
    front :: q a -> a