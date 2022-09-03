library IEEE;
use IEEE.std_logic_1164.all;

entity encoder8x3 is
    port(d0,d1,d2,d3,d4,d5,d6,d7: in bit;
       x,y,z: out bit);
end encoder8x3;

architecture structure of encoder8x3 is

   component or4 -- πύλη or 4 εισόδων
    port(i0,i1,i2,i3: in bit; F: out bit);
   end component;
    
    begin
    u0: or4 port map (d7,d6,d5,d4,x);
    u1: or4 port map (d7,d6,d3,d2,y);
        u2: or4 port map (d7,d5,d3,d1,z);
end structure;

entity or4 is
port (i0,i1,i2,i3: in bit; F: out bit);
end or4;

architecture behave of or4 is
begin F<= i0 or i1 or i2 or i3;
end behave;
