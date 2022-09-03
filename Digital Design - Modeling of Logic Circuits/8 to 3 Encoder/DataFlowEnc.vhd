library IEEE;
use IEEE.std_logic_1164.all;

entity encoder8x3 is
    port(d0,d1,d2,d3,d4,d5,d6,d7: in bit;
       x,y,z: out bit);
end encoder8x3;

architecture dataflow of encoder8x3 is
    begin
    x <= d7 or d6 or d5 or d4;
    y <= d7 or d6 or d3 or d2;
    z <= d7 or d5 or d3 or d1;
end dataflow;
