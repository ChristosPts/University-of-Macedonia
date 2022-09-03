library IEEE;
use IEEE.std_logic_1164.all;

entity ParityGenenerator is
    port(A,B,C: in bit;X: inout bit; P: out bit);
end ParityGenenerator;

architecture dataflow of ParityGenenerator is
begin
    X <= A xor B;
    P <= X xor C;
end dataflow;
