module Ficha1 where

import Data.Maybe

data LTree a = Leaf a | Fork (LTree a , LTree a)

mylength :: [a] -> Int
mylength [] = 0
mylength (h:t) = 1 + mylength t

myreverse :: [a] -> [a]
myreverse (h:t) = aux [h] t
    where
          aux l [] = l
          aux l (h:t) = aux (h:l) t

reverseAula [] = []
reverseAula [a] = [a]
reverseAula (h : t) = reverseAula t ++ [h]

mycatMaybes :: [Maybe a] -> [a]
mycatMaybes [] = []
mycatMaybes ((Just a) : t) = a : mycatMaybes t
mycatMaybes (h:t) = mycatMaybes t

catMaybesAula :: [Maybe a] -> [a]
catMaybesAula [] = []
catMaybesAula [Just a] = [a]
catMaybesAula [Nothing] = []
catMaybesAula (h:t) = catMaybesAula [h] ++ catMaybesAula t

myuncurry :: (a -> b -> c) -> (a,b) -> c
myuncurry f (a,b) =  f a b

mycurry :: ((a,b) -> c) -> a -> b -> c
mycurry f a b = f (a,b)

add (x,y) = x + y

flip :: (a -> b -> c) -> b -> a -> c
flip f b a = f a b

flatten :: LTree a  -> [a]
flatten (Leaf a) = [a]
--flatten (Fork (Leaf a, r)) = a : flatten r
flatten (Fork (l,r)) = flatten l ++ flatten r

mirror :: LTree a -> LTree a
mirror (Leaf a) = Leaf a
mirror (Fork (l,r)) = Fork(mirror r, mirror l)

myfmap :: (a -> b) -> LTree a -> LTree b
myfmap f (Leaf a) = Leaf (f a)
myfmap f (Fork (l,r)) = Fork(myfmap f l , myfmap f r)

mylength2 :: [a] -> Int
mylength2 l = foldr (\x y -> succ y) 0 l

myconcat :: [[a]] -> [a]
myconcat [] = []
myconcat ([]:t) = myconcat t
myconcat ((x:xs):t) = x : myconcat (xs:t)

coiso :: [Int] -> [Int]
coiso l = foldr (\x list -> if x>0 then (x+1):list else list) [] l
