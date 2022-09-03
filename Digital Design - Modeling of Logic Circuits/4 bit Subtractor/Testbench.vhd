Testbench
library IEEE;
use IEEE.std_logic_1164.all;

entity test_Subtractor4bit is
end test_Subtractor4bit;

architecture testbench of test_Subtractor4bit is

component Subtractor4bit port (
A, B: in bit_vector (3 downto 0);
diff: out bit_vector (3 downto 0);
borrow: inout bit_vector(4 downto 0));
end component;

signal tb_A: bit_vector(3 downto 0);
signal tb_B: bit_vector(3 downto 0);
signal tb_diff: bit_vector(3 downto 0);
 
begin
u0: Subtractor4bit port map(
A=> tb_A,
B=> tb_B,
diff=> tb_diff);

process
begin
-- 0100 – 0001 = 0011
tb_A<="0100";
tb_B<="0001";
wait for 10 ns;
--1100 – 0101 = 0111
tb_A<="1100";
tb_B<="0101";
wait for 10 ns;
-- 1111 – 1111 = 0000
tb_A<="1111";
tb_B<="1111";
wait for 10 ns;
-- 0100 – 0001 = 0011
tb_A<="0110";
tb_B<="0011";
wait for 10 ns;
-- 1000 – 0101 = 0110
tb_A<="1100";
tb_B<="0010";
wait for 10 ns;

end process;
end testbench;
